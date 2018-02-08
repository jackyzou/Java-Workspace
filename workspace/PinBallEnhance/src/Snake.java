import java.applet.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Snake extends JFrame implements KeyListener ,Runnable

{

    Thread t=null;

    Image offs;

    Graphics gra;

    int direc=3;

    snake she;

    food shi;//不知我当时为何将蛇的食物当成了屎，哈哈

    zhangai zu;

    int flag=0;

    int jibie=0;

    int biaozhi=0;

    int fen=0;

    int delay=600;

    int ci=-1;

    boolean xing;

    int jieshu=0;   //结束的次数

    JPanel mainp;

    int zhanwei[][]=new int[1444][1444];

    Image im;

    public Snake()

    {

     String imagef=System.getProperty("user.dir")+"/2.PNG";

     im=getToolkit().getImage(imagef);

     xing=true;

     she=new snake(4,zhanwei);

     shi=new food();

     zu=new zhangai(5,zhanwei);

     zu.zushu=5;

     shi.yes=true;

     mainp=new JPanel();

     mainp.addKeyListener(this);

     mainp.setFocusable(true);

     getContentPane().setLayout(null);

     getContentPane().add(mainp);

     mainp.setBounds(10,10,740,380);

     setTitle("贪吃蛇");

     setSize(700,450);

     setResizable(false);

     setVisible(true);

     for(int i=0;i<1444;i++)

       for(int j=0;j<1444;j++)

        {

          zhanwei[i][j]=0;

         }

     t=new Thread(this);

     t.start();

    }

    public void paint(Graphics g)

    {

    g = mainp.getGraphics();

    g.setFont(new Font("",2,20));

    g.setColor(Color.blue);

    g.drawString("得分：",400,30);

    g.drawString("您的级别：",400,80);

    g.drawString(":暂停/开始|:重新开始",400,130);

    g.drawString(":加速|:减速",400,180);

    g.drawString("游戏须知：",400,230);

    g.drawRect(420,250,200,110);

    g.setFont(new Font("",0,15));

    g.drawString("1：吃掉兰色方块时加分",430,268);

    g.drawString("2：出现红色方块时不能碰，",430,288);

    g.drawString("否则游戏结束。",451,308);

    g.drawString("3：不能碰墙或自身，否则",430,328);

    g.drawString("否则游戏结束。",451,348);

    g.clearRect(520,15,100,100);

    g.setFont(new Font("",2,20));

    g.drawString(""+fen,520,30);

    g.drawString(""+jibie,520,80);

    if(biaozhi==0)

    {

    for(int i=0;i<380;i+=10)

      for(int j=0;j<380;j+=10)

        {

         if(zhanwei[i/10][j/10]==0)

          {

            g.setColor(Color.orange);

            g.drawRect(i,j,10,10);

            g.setColor(Color.lightGray);

            if(i==370)

              g.fillRect(i,j,11,9);

            else

              g.fillRect(i,j,9,9);

          }

         else if(zhanwei[i/10][j/10]==1)

          {

            g.setColor(Color.blue);

            g.fillRect(i,j,9,9);

           }

          else if(zhanwei[i/10][j/10]==2)

          {

            g.setColor(Color.red);

            g.fillRect(i,j,9,9);

           }

        }

       }

       if(biaozhi==1||she.x[0]==-10||she.y[0]==-10)

         {

            for(int i=0;i<380;i+=10)

             for(int j=0;j<380;j+=10)

              {

                g.setColor(Color.orange);

                g.drawRect(i,j,10,10);

                g.setColor(Color.lightGray);

                if(i==370)

                  g.fillRect(i,j,11,9);

                else

                  g.fillRect(i,j,9,9);

              }

             g.setFont(new Font("华文彩云",3,30));

             g.setColor(Color.red);

             g.drawString("GAME OVER",90,140);

             g.setFont(new Font("",4,20));

             g.drawString("您的得分："+fen,90,190);

        }

    }

    public void run()

    {

    try{

        while(true)

          {

          //食物的产生也要看障的情况

             if(xing)

             {

               if(shi.yes)

                 { 

                    boolean chong=false;

                    int lix=(int)(Math.random()*300)+40;

                    int liy=(int)(Math.random()*300)+40;

                    int baix=(int)(Math.random()*300)+40;

                    int baiy=(int)(Math.random()*20)+10;

                    for(int i=0;i

                     {

                        if(((lix-lix%10)==zu.x[i]&&(liy-liy%10)==zu.y[i])||((lix-lix%10+10)==zu.x[i]&&(liy-liy%10)==zu.y[i])||((lix-lix%10)==zu.x[i]&&(liy-liy%10+10)==zu.y[i])||((lix-lix%10-10)==zu.x[i]&&(liy-liy%10)==zu.y[i])||((lix-lix%10)==zu.x[i]&&(liy-liy%10-10)==zu.y[i]))

                          {

                            chong=true;

                            break;

                          }

                      }

                     if(zhanwei[(lix-lix%10)/10][(liy-liy%10)/10]==1)

                        chong=true;

                     if(chong)

                       {

                           shi.x=baix-baix%10;

                           shi.y=baiy-baiy%10;

                       }

                     if(!chong)

                       {

                          shi.x=lix-lix%10;

                          shi.y=liy-liy%10;

                        }

                    zhanwei[shi.x/10][shi.y/10]=1;

                    shi.yes=false;

                 }

               if(she.x[0]==shi.x&&she.y[0]==shi.y)

                {

                 she.renode(she.node,she.x,she.y);

                 shi.yes=true;

                 zhanwei[shi.x/10][shi.y/10]=0;

                 fen+=20;

                 if(fen%100==0)

                  {

                    jibie++;

                    if(jibie>=10)

                     {

                        zu.zushu=0;/////////////////////////////////////////

                     }

                    else

                    {

                      if(jibie>1)

zu.xiezu(zu.x,zu.y);

                      zu.zushu+=4;

                      zu.reshu(zu.zushu,she.x[0],she.y[0],shi.x,shi.y);  //,zu.x,zu.y);////////////////////

}

                  }

                }

               for(int i=2;i

               {

                 if(she.x[0]==she.x[i]&&she.y[0]==she.y[i])

                   {

                     flag=1;

                     break;

                   }

               }

              for(int i=0;i

               {

                 if(she.x[0]==zu.x[i]&&she.y[0]==zu.y[i])

                   {

                     flag=1;

                     jieshu++;

                     break;

                   }

               }

              if(she.x[0]>370||she.x[0]<0||she.y[0]<0||she.y[0]>370||flag==1)

                 {

                    biaozhi=1;

                    repaint();

                    break;

                   }

                if(biaozhi!=1)

               she.zou(direc);

            Thread.sleep(delay);

            repaint();

          }

       }

    }catch(Exception e){}

    }

    public void keyPressed(KeyEvent ke)

    {

     }

    public void keyReleased(KeyEvent ke)

    {

     }

    public void keyTyped(KeyEvent ke)

    {

    if((""+ke.getKeyChar()).equals("w"))

      {

        direc=she.fangxiang("w");

        if(she.y[0]>0)

         she.zou(direc);

      }

    else if((""+ke.getKeyChar()).equals("s"))

      {

       direc=she.fangxiang("s");

       she.zou(direc);

     }

    else if((""+ke.getKeyChar()).equals("a"))

      {

        direc=she.fangxiang("a");

        if(she.x[0]>0)

          she.zou(direc);

       }

    else if((""+ke.getKeyChar()).equals("d"))

      {

       direc=she.fangxiang("d");

       she.zou(direc);

     }

    else if((""+ke.getKeyChar()).equals("b"))

       {

        if(t.isAlive() )

          t.interrupt();

        t=new Thread(this);

        for(int i=0;i<1444;i++)

       for(int j=0;j<1444;j++)

        {

          zhanwei[i][j]=0;

         }

        she=new snake(4,zhanwei);

        shi=new food();

        shi.yes=true;

        zu=new zhangai(5,zhanwei);

        zu.zushu=5;

        xing=true;

        Graphics g = mainp.getGraphics();

        g.clearRect(0,0,380,380);

        direc=3;

        ci=-1;

        flag=0;

        jibie=0;

        biaozhi=0;

        fen=0;

        delay=600;

        she.zou(3);

        t.start();

      }

      else if((""+ke.getKeyChar()).equals("t"))

          {

            ci++;

            if(ci%2==0)

              xing=false;

            else if(ci%2==1)

              xing=true;

          }

      else if((""+ke.getKeyChar()).equals("j"))

        {

            if(delay>=50)

              delay-=50;

        }

      else if((""+ke.getKeyChar()).equals("k"))

        {

              delay+=50;

        }

      }

    public static void main(String str[])

    {

        new Snake();

    }

}

class snake

{

    int x[];

    int y[];

    int node=4;

    int yipx;

    int yipy;

    int zhan[][];

    public snake(int nod,int[][] zhan)

    { 

            x=new int[nod];

        y=new int[nod];

        this.zhan=zhan;

        for(int i=0;i

         {

          x[i]=190+i*10;

          y[i]=190;

          zhan[x[i]/10][19]=1;

         }

    }

    public int fangxiang(String str)

    {

        int re=0;

        if(str.equals("w"))

           re=1;

        else if(str.equals("s"))

           re=2;

        else if(str.equals("a"))

           re=3;

        else if(str.equals("d"))

           re=4;

        return re;

    }

    public void renode(int laonode,int[] xn,int[] yn)

    { 

            node++;

            x=new int[laonode+1];

        y=new int[laonode+1];

        for(int i=0;i

         {

           x[i]=xn[i];

           y[i]=yn[i];

           zhan[x[i]/10][y[i]/10]=1;

          }

        x[laonode]=yipx;

        y[laonode]=yipy;

    }

    public void zou(int direction)

    {

        int linshi=0;

        zhan[x[node-1]/10][y[node-1]/10]=0;

        if(direction==1)

          {

            linshi=y[0];

            yipx=x[node-1];

            yipy=y[node-1];

            for(int i=node-1;i>0;i--)

             {

                x[i]=x[i-1];

                y[i]=y[i-1];

                zhan[x[i]/10][y[i]/10]=1;

}

            y[0]=linshi-10;

            zhan[x[0]/10][y[0]/10]=1;

}

        else if(direction==2)

         {

          linshi=y[0];

yipx=x[node-1];

          yipy=y[node-1];

for(int i=node-1;i>0;i--)

             {

                x[i]=x[i-1];

                y[i]=y[i-1];

                zhan[x[i]/10][y[i]/10]=1;

}

           y[0]=linshi+10;

           zhan[x[0]/10][y[0]/10]=1;

}

        else if(direction==3)

          {

            linshi=x[0];

yipx=x[node-1];

            yipy=y[node-1];

for(int i=node-1;i>0;i--)

             {

                x[i]=x[i-1];

                y[i]=y[i-1];

                zhan[x[i]/10][y[i]/10]=1;

}

            x[0]=linshi-10;

            zhan[x[0]/10][y[0]/10]=1;

}

        else if(direction==4)

          {

            linshi=x[0];

yipx=x[node-1];

            yipy=y[node-1];

for(int i=node-1;i>0;i--)

             {

                x[i]=x[i-1];

                y[i]=y[i-1];

                zhan[x[i]/10][y[i]/10]=1;

}

             x[0]=linshi+10;

             zhan[x[0]/10][y[0]/10]=1;

}

    }

}

class food

{

    int x;

    int y;

    boolean yes;//判断是否要出现食物的变量

}

class zhangai

{

    int x[];

    int y[];

    int zushu;

    int zhan[][];

    public zhangai(int nod,int[][] zhan)

    { 

        this.zhan=zhan;

        x=new int[nod];

        y=new int[nod];

        for(int i=0;i

         {

           x[i]=-20;

           y[i]=-20;

         }

    }

    public void xiezu(int[] x,int[] y)

    {

        for(int i=0;i

         {

            if(x[i]>10&&y[i]>0)

            zhan[x[i]/10][y[i]/10]=0;

         }

    }

    public void reshu(int za,int px,int py,int sx,int sy)

    { 

        x=new int[za];

        y=new int[za];

        for(int i=0;i

         {

           int lix=(int)(Math.random()*320)+40;

           int zux=lix-lix%10;

           int liy=(int)(Math.random()*320)+40;

           int zuy=liy-liy%10;

           if(px!=zux&&(px+10)!=zux&&(px-10)!=zux&&(px-20)!=zux&&(px+20)!=zux&&(px-30)!=zux&&(px+30)!=zux&&(py-30)!=zuy&&(py+30)!=zuy&&sx!=zux&&(sx+10)!=zux&&(sx-10)!=zux&&(sx-20)!=zux&&(sx+20)!=zux&&py!=zuy&&(py+10)!=zuy&&(py-10)!=zuy&&(py-20)!=zuy&&(py+20)!=zuy&&sy!=zuy&&(sy+10)!=zuy&&(sy-10)!=zuy&&(sy-20)!=zuy&&(sy-30)!=zuy&&(sy+30)!=zuy&&(sx-30)!=zux&&(sx+30)!=zux&&(sy+20)!=zuy)

            {

                x[i]=zux;

                y[i]=zuy;

                zhan[x[i]/10][y[i]/10]=2;

            }

           else

              {

                x[i]=-20;

                y[i]=-20;

              }

         }

    }

}