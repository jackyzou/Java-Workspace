import java.awt.*;

import java.applet.*;

import javax.swing.*;

import java.awt.event.*;

import java.util.*;

import java.lang.Integer;



/*障碍1

*子弹2

*小车3

*定义三个向量存储下落的字符

*/

public class tanqiu extends JApplet implements Runnable,KeyListener

{

    int kuai[][]=new int[45][38];

    Thread t=null;

shangzu zu=null;

    zidan dan=null;

board che=null;

    jiangpin jiang=null;

    ctrl con=null;

    boolean begin=false;       //判断开始游戏

    int type=-1;

    int stepmod=-1;

    int p=-1;           //pause or move

    int slee=400;

    boolean stepshow=false;

    boolean pause=false;

    boolean reb=false;

    boolean chushi=false;

    Vector zifu=new Vector();

    Vector zx=new Vector();

    Vector zy=new Vector();

    int modle=-1;

    public void init()

    {

        for(int i=0;i<45;i++)

          for(int j=0;j<38;j++)

            kuai[i][j]=0;

        zu=new shangzu(kuai);

        dan=new zidan(kuai);

        che=new board(kuai);

        jiang=new jiangpin(zifu);

        con=new ctrl();

        che.shengcheng();

        addKeyListener(this);

        setFocusable(true);

    }

    public void paint(Graphics g)

    {

        g.drawLine(19,19,470,19);

        g.drawLine(19,19,19,400);

        g.drawLine(470,19,470,400);

        g.drawLine(19,400,470,400);

        g.setColor(Color.green);

        g.setFont(new Font("",2,20));

        g.drawString("重新开始",600,32);

        g.setColor(Color.blue);

        g.drawString("选择级别",600,65);

        if(modle%2==0)

        {

          g.clearRect(489,49,82,22);

          g.setColor(Color.gray);

          g.drawRect(490,23,60,14);

          g.drawLine(550,23,560,30);

          g.drawLine(550,37,560,30);   

        }

        if(modle%2==1)

        {

          g.clearRect(489,19,82,22);   

          g.setColor(Color.gray);

          g.drawRect(490,53,60,14);

          g.drawLine(550,53,560,60);

          g.drawLine(550,67,560,60);

        }

        if(stepshow==true)

        {

            g.setColor(Color.blue);

            g.drawString("一级",650,99);

            g.setColor(Color.blue);

            g.drawString("二级",650,134);

            g.setColor(Color.blue);

            g.drawString("三级",650,164);

            if(stepmod%3==0)

             {

               g.clearRect(530,120,80,20);

               g.clearRect(530,150,80,20);

               g.setColor(Color.gray);

               g.drawRect(530,90,50,19);   

             }

            if(stepmod%3==1)

             {

               g.clearRect(530,90,80,20);

               g.clearRect(530,150,80,20); 

               g.setColor(Color.gray);

               g.drawRect(530,120,50,19);

             }

             if(stepmod%3==2)

             {

               g.clearRect(530,90,80,20);

               g.clearRect(530,120,80,20); 

               g.setColor(Color.gray);

               g.drawRect(530,150,50,19);

             }

         }

        else if(stepshow==false)

          g.clearRect(500,88,180,250);

        if(reb==false)

        {

        for(int i=20;i<470;i+=10)

          for(int j=20;j<400;j+=10)

          {

            if(kuai[i/10-2][j/10-2]==0)

            {

                g.setColor(Color.white);

                g.fill3DRect(i,j,10,10,true);

            }

            else if(kuai[i/10-2][j/10-2]==1)

            {

                g.setColor(Color.blue);

                g.fill3DRect(i,j,10,10,true);

            }

           else if(kuai[i/10-2][j/10-2]==2)

            {

                g.setColor(Color.black);

                g.fillOval(i,j,10,10);

            }

          else if(kuai[i/10-2][j/10-2]==3)

            {

                g.setColor(Color.green);

                g.fill3DRect(i,j,10,10,true);

            }

          }

          if(!(zifu.isEmpty()))

          {

            g.setColor(Color.black);

            g.setFont(new Font("",2,15));

            for(int i=0;i<100000;i++)

            {

             g.drawString((String)zifu.elementAt(i),((Integer)zx.elementAt(i)).intValue(),((Integer)zy.elementAt(i)).intValue());

            }

           }

          }

          if(reb==true)

          {

            g.setColor(Color.red);

            g.setFont(new Font("",3,40));

            g.drawString("GAME OVER",88,210);

          }

    }

    public void start()

    {

        t=new Thread(this);

        t.start();

    }

    public void run()

    {

        while(true)

        {

          if(pause==false)

          {

            if(zu.yes==true)

            {

                zu.shengcheng();

                zu.jishu();

                //System.out.println(zu.count);

                zu.yes=false;

            }

            if(begin==true)

            {

                dan.control(1);

                type=1;

                begin=false;

                chushi=true;

            }

            if((begin==false&&chushi==false)||chushi==false)

            {

                dan.control(che.ty);

            }

            if(chushi==false)

            {

                if(kuai[dan.x][dan.y]==1)

                 zu.jianshu();

            }

            /*控制子弹的不撞击情况下的方向

             */

            if(dan.x==44)

            {

                if(type==1)

                  type=2;

                if(type==4)

                  type=3;

            }

            else if(dan.y==0)

            {

                if(type==2)

                  type=3;

                if(type==1)

                  type=4;

            }

            else if(dan.x==0)

            {

                if(type==3)

                  type=4;

                if(type==2)

                  type=1;

            }

            else if(dan.y==36)

            {

                type=0;

                dan.life=false;

                reb=true;

            }

            /*子弹的撞击

             */

            if(dan.life==true)

            {

                if(type==1)

                 {

                   if(kuai[dan.x+1][dan.y-1]==1)

                    {

                     try

                     {

                      kuai[dan.x+1][dan.y-1]=0;

                      type=4;

                      jiang.mode();

                      Integer jx=new Integer((dan.x+1)*10+20);///////////////

                      zx.addElement(jx);

                      Integer jy=new Integer((dan.y-1)*10+20);//////////////

                      zy.addElement(jy);

                     }catch(Exception ee){

                     }

                     zu.jianshu();

                    }

                 }

                else if(type==2)

                 {

                   if(kuai[dan.x-1][dan.y-1]==1)

                    {

                     try

                     {

                      kuai[dan.x-1][dan.y-1]=0;

                      type=3;

                      jiang.mode();

                      Integer jx=new Integer((dan.x-1)*10+20);///////////

                      zx.addElement(jx);

                      Integer jy=new Integer((dan.y-1)*10+20);/////////////

                      zy.addElement(jy);

                     }catch(Exception ee){

                     }

                     zu.jianshu();

                    }

                 }

               else if(type==3)

                {

                  if(kuai[dan.x-1][dan.y+1]==1)

                  {

                    try

                    {

                      kuai[dan.x-1][dan.y+1]=0;

                      type=2;

                      jiang.mode();

                      Integer jx=new Integer((dan.x-1)*10+20);////////////

                      zx.addElement(jx);

                      Integer jy=new Integer((dan.y+1)*10+20);////////////

                      zy.addElement(jy);

                    }catch(Exception ee){

                   }

                   zu.jianshu();

                }

            }

            else if(type==4)

            {

                if(kuai[dan.x+1][dan.y+1]==1)

                {

                    try

                    {

                      kuai[dan.x+1][dan.y+1]=0;

                      type=1;

                      jiang.mode();

                      Integer jx=new Integer((dan.x+1)*10+20);///////////////

                      zx.addElement(jx);

                      Integer jy=new Integer((dan.y+1)*10+20);/////////////

                      zy.addElement(jy);

                    }catch(Exception ee){

                    }

                    zu.jianshu();

                }

            }

           }

            /*以下处理与小车的碰撞  */

            if(type==3)

            {

                if(kuai[dan.x-1][dan.y+1]==3)

                  type=2;

            }

            if(type==4)

            {

                if(kuai[dan.x+1][dan.y+1]==3)

                  type=1;

            }

            dan.control(type);

            if(!(zy.isEmpty()))

            {

            	  for(int i=0;i<100000;i++)

                {

                    Integer l=new Integer(((Integer)zy.elementAt(i)).intValue()+10);

                    zy.insertElementAt(l,i);

                    zy.remove(i+1);

                }

            }

            /*以下处理字符与小车的撞击

             *字符落到显示区域以外则不见

             */

            if(!(zy.isEmpty()))

            {

            	  for(int i=0;i<100000;i++)

                {

                    if(kuai[((Integer)zx.elementAt(i)).intValue()/10-2][((Integer)zy.elementAt(i)).intValue()/10-2]==3||((Integer)zy.elementAt(i)).intValue()>385)

                     {

                        if(kuai[((Integer)zx.elementAt(i)).intValue()/10-2][((Integer)zy.elementAt(i)).intValue()/10-2]==3)

                        {

                          if(((String)zifu.elementAt(i)).equals("L"))

                          {

                            if(che.width<15&&che.start<44-che.width)

                              che.wider();

                          }

                          if(((String)zifu.elementAt(i)).equals("G"))

                             con.state=false;

                          if(((String)zifu.elementAt(i)).equals("F"))

                          {

                            if(chushi==true)

                              chushi=false;

                            else if(chushi==false)

                              chushi=true;

                          }

                           /*

                            *

                            */

                         }

                       //计算出三个向量的索引

                       zifu.remove(i);

                       zx.remove(i);

                       zy.remove(i);

                     }

                }

            }

            if(con.state==false)

             {

                con.trick++;

                if(con.trick==20)

                 {

                    con.state=true;

                    con.trick=0;

                 }

             }

           if(zu.count==0)

           {

             zu.yes=true;

           }

           }

           try

            {

                Thread.sleep(slee);

            }

            catch(Exception exe)

            {

            }

           //System.out.println(zu.count);

           int cc=0;

           for(int i=0;i<45;i++)

             for(int j=0;j<38;j++)

              {

                if(kuai[i][j]==1)

                  cc++;

              }

           System.out.println(cc);

           if(cc==40)

           {

             zu.yes=true;

           }

           repaint();

         }

    }

  public void keyPressed(KeyEvent ke)

  {

  }

  public void keyReleased(KeyEvent ke)

  {

  }

  public void keyTyped(KeyEvent ke)

  {

    if((""+ke.getKeyChar()).equals("b"))

    {

        begin=true;

        //chushi=true;

        if(reb==true)

          rebegin();

    }

    else if((""+ke.getKeyChar()).equals("d"))

    {

        if(con.state==true)

          che.move(5);

    }

    else if((""+ke.getKeyChar()).equals("a"))

    {

        if(con.state==true)

           che.move(6);

    }

    else if((""+ke.getKeyChar()).equals("w"))

    {

        che.move(7);

    }

    else if((""+ke.getKeyChar()).equals("u"))

    {

        p++;

        if(p%2==0)

          pause=true;

        else if(p%2==1)

          pause=false;

    }

    else if((""+ke.getKeyChar()).equals("i"))

    {

        pause=false;

    }

    if((""+ke.getKeyChar()).equals("k"))//down

     {

        if(stepshow==false)

          modle++;

        if(stepshow==true)

          stepmod++;

     }

    if((""+ke.getKeyChar()).equals("o"))  //VK_ENTER

    {

        if(stepshow==false)

        {

         if(modle%2==0)

          {

            rebegin();

         }

         else if(modle%2==1)

          {

            stepshow=true;

          }

        }

        if(stepshow==true)

        {

            if(stepmod%3==0)

            {

              slee=400;

              stepshow=false;

            }

            else if(stepmod%3==1)

            {

              slee=200;

              stepshow=false;

            }

            else if(stepmod%3==2)

            {

              slee=100;

              stepshow=false;  

            }

        }

    }

  }

public void rebegin()

{

    begin=false;

    pause=false;

    chushi=false;

    p=-1;

    reb=false;

    type=-1;

    stepshow=false;

    zifu=new Vector();

    zx=new Vector();

    zy=new Vector();

    for(int i=0;i<45;i++)

      for(int j=0;j<38;j++)

        kuai[i][j]=0;

    zu=new shangzu(kuai);

    modle=-1;

    stepmod=-1;

    slee=400;

    dan=new zidan(kuai);

    che=new board(kuai);

    jiang=new jiangpin(zifu);

    con=new ctrl();

    che.shengcheng();

}

public void destroy()

{

    //System.exit(0);

} 

}

class shangzu

{

    boolean yes=true;

    int kuai[][];

    int count=0;

    public shangzu(int[][] kuai)

    {

        this.kuai=kuai;

    }

    public void shengcheng()

    {

        for(int i=0;i<150;i++)

        {

            int zux=(int)(Math.random()*41+2);

            int zuy=(int)(Math.random()*14+2);

            kuai[zux][zuy]=1;

        }

    }

    public void jishu()

    {

        for(int i=0;i<45;i++)

          for(int j=0;j<38;j++)

          {

            if(kuai[i][j]==1)

              count++;

          }

    }

    public void jianshu()

    {

        count--;

    }

}

class zidan

{

    int x=4;

    int y=33;

    int kuai[][];

    boolean life=true;

    public zidan(int[][] kuai)

    {

        this.kuai=kuai;

    }

    public void control(int type)

    {

        /*两个临时变量的定义，发生了一件令人快乐的事，

         *使我不必再去定义新的方法来消去撞击的障碍物；

         */

        int linx;

        int liny;

        linx=x;

        liny=y;

        switch(type)

        {

            case 1:

            {

                x++;

                y--;

                break;

            }

            case 2:

            {

                x--;

                y--;

                break;

            }

            case 3:

            {

                x--;

                y++;

                break;

            }

            case 4:

            {

                x++;

                y++;

                break;

            }

            case 0:

            {

                break;

            }

            case 5:

            {

                if(x<40)

                  x++;

                break;

            }

            case 6:

            {

                if(x>0)

                  x--;

                break;

            }

            case 7:

            {

                if(y>18)

                  y--;

                break;

            }

        }

        kuai[linx][liny]=0;

        kuai[x][y]=2;

    }

}

class board

{

    int kuai[][];

    int start=0;

    int lin;

    int cha=0;

    int liny;

    int width=8;

    int ty=0;

    zidan zd=null;

    public board(int[][] kuai)

    {

        this.kuai=kuai;

        zd=new zidan(kuai);

    }

    public void shengcheng()

    {

    	  for(int i=0;i<100000;i++)

          kuai[i][34]=3;

    }

    public void move(int lei)

    {

        ty=lei;

        switch(lei)

        {

            case 5:

            {

                lin=start;

                if(start<45-width)

                {

                    start++;

                    for(int i=start;i<100000;i++)

                      if(i<45)

                        kuai[i][34+cha]=3;

                     kuai[lin][34+cha]=0;

                }

                break; 

            }

            case 6:

            {

                lin=start+width-1;

                if(start>0)

                {

                    start--;

                    for(int i=start;i<100000;i++)
                     //if(i>45)

                      kuai[i][34+cha]=3;

                    //if(lin<45)

                    kuai[lin][34+cha]=0;

                }

               break;  

            }

            case 7:

            {

                liny=cha;

                if(cha>-15)

                  cha--;

                for(int i=start;i<100000;i++)
                   kuai[i][34+cha]=3;

                if(liny>-15)

                    for(int i=start;i<100000;i++)

                   kuai[i][34+liny]=0;

                break;

            }

        }

    }

    public void wider()

    {

        width++;

        for(int i=start;i<100000;i++)

          if(i<45)

            kuai[i][34+cha]=3;

    }

}

class jiangpin

{

    String letter=null;

    Vector zifu;

    public jiangpin(Vector zifu)

    {

        this.zifu=zifu;

    }

    public void mode()

    {

        int mod=(int)(Math.random()*3);

        switch(mod)

        {

            case 0:

            {

                letter="L";//big

                break;

            }

            case 1:

            {

                letter="G";//nianzhu

                break;

            }

            case 2:

            {

                letter="F";//life

                break;

            }

        }

        zifu.addElement(letter);

    }

}

class ctrl

{

    boolean state=true;

    int trick=0;

}

