/*Diana Negoescu '09
 * program 'reads' handwriting (or at leats tries...) disregarding the dots on the i's
 * execution java Marcovcalphai training_text.txt picture_name.jpg c alpha
 * c does not matter, and alpha should be around 9 or 10
 */

import java.awt.Color;

public class BarCode{
  
  //function that computes the luminance of a pixel
  public static double lum(Color color){
    int r=color.getRed();
    int g=color.getGreen();
    int b=color.getBlue();
    return .299*r+.587*g+.114*b;
  }
  //function that transforms a picture into a black and white one of same
  //dimension
  public static Picture blackwhite(String filename){
    Picture source=new Picture(filename);
    int w=source.width();
    int h=source.height();
    Picture result=new Picture(w,h);
    Color black=new Color(0,0,0);
    Color white=new Color(255, 255, 255);
    double max=0.0;
    double min=255.0;
    double av=0;
    for (int i=0; i<h; i++){
      for (int j=0; j<w; j++){
        Color color=source.get(j,i);
        av=av+lum(color);
      }
    }
    av=av/(w*h);
    for (int i=0; i<h; i++){
      for (int j=0; j<w; j++){
        Color color=source.get(j,i);
        if (lum(color)>240) result.set(j,i,white);
        else result.set(j,i,black);
      }
    }
    return result;
    
  }
  public static void floodfillstack(Picture pic, int[][] a, Stack s, Color c,
                                    int k){ 
    while (!s.isEmpty()){
      Stack.Node x=s.pop();
      if ((x.i>=pic.height())||(x.j>=pic.width())||(x.i<0)||(x.j<0)){
        continue;
      }
      Color col=pic.get(x.j,x.i);
      if (col.equals(Color.WHITE)) continue;
      if (a[x.i][x.j]!=0) continue;
      s.push(x.i+1,x.j);
      s.push(x.i,x.j-1);
      s.push(x.i-1,x.j);
      s.push(x.i,x.j+1);
      a[x.i][x.j]=k;
    }
  }
  
  
  static boolean less(double x, double y) {
    return (x < y);
  }
  
  static void exch(Letter[] a,int[] mmin, int[] mmax, int[] jmin, int[] jmax, int i, int j) {
    Letter swapl = a[i];
    a[i] = a[j];
    a[j] = swapl;
    int swap=mmin[i];
    mmin[i]=mmin[j];
    mmin[j]=swap;
    swap=mmax[i];
    mmax[i]=mmax[j];
    mmax[j]=swap;
    swap=jmin[i];
    jmin[i]=jmin[j];
    jmin[j]=swap;
    swap=jmax[i];
    jmax[i]=jmax[j];
    jmax[j]=swap;
    
  } 
  
  static void exch1(int[] a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
  
  static void insertionSort(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++)
      for (int j = i; j > 0; j--)
      if (less(a[j], a[j-1]))
      exch1(a, j, j-1);
    else break;
  }
  
  
  
  static int partition(Letter[] a, int[] mmin,int[] mmax,int[] jmin,int[] jmax, int left, int right) {
    int i = left - 1;
    int j = right;
    
    while(true) { 
      while (less(mmin[++i], mmin[right]))   // left pointer
        if (i == right) break;
      
      while (less(mmin[right], mmin[--j]))   // right pointer
        if (j == left) break;
      
      if (i >= j) break;               // pointers cross?
      
      exch(a, mmin, mmax, jmin, jmax,i, j);                   // swap left and right
    }
    
    exch(a, mmin, mmax, jmin, jmax, i, right);                  // swap pivot
    return i;
  }
  
  public static void quicksortgen(Letter[] a, int b, int i, int[] mmin, int[] mmax,int[] jmin,int[] jmax) {
    quicksort(a, mmin,mmax, jmin, jmax, b, i);
  }
  
  private static void quicksort(Letter[] a,int[] mmin,int[] mmax,int[] jmin,int[] jmax, int left,int right){
    if (right <= left) return;
    int i = partition(a, mmin, mmax, jmin, jmax,left, right);
    quicksort(a, mmin, mmax, jmin, jmax,left, i-1);
    quicksort(a, mmin, mmax, jmin, jmax, i+1, right);
  }
  
  static Letter[] insertblank(Letter[] letters, int k){
    int[][] blank=new int[40][50];
    
    Letter blanklet=new Letter(blank, ' ');
    Letter[] letmod=new Letter[letters.length];
    for (int i=0; i<=k; i++){
      
      letmod[i]=letters[i];
    }
    letmod[k+1]=blanklet;
    for (int i=k+2; i<letmod.length; i++){
      letmod[i]=letters[i-1];
    }
    return letmod;
  }
  
  //function that extracts the letters from a 'flood' matrix
  public static Letter[] extract(int[][] a, int h, int w, int k){
    
    int[] mmin=new int[k-1];
    int[] jmin=new int[k-1];
    int[] jmax=new int[k-1];
    int[] mminp=new int[k-1];
    int[] mmaxp=new int[k-1];
    
    for (int i=1; i<k; i++){
      
      //find out the maximum and minimum coordinates of each letter
      jmin[i-1]=h;
      jmax[i-1]=0;
      mmaxp[i-1]=0;
      mminp[i-1]=h;
      for (int j=0; j<h; j++){
        for (int m=0; m<w; m++){
          if ((a[j][m]==i)&&(j<jmin[i-1])) 
            jmin[i-1]=j;
          if ((a[j][m]==i)&&(j>jmax[i-1])) 
            jmax[i-1]=j;
          if ((a[j][m]==i)&&(m>mmaxp[i-1])) 
            mmaxp[i-1]=m;
          if ((a[j][m]==i)&&(m<mminp[i-1])) 
            mminp[i-1]=m;
          
        }
      }
    }
    //count how many blobs are bigger than 10 pixels
    int p=0;
    for (int i=1; i<k; i++){
      if ((jmax[i-1]-jmin[i-1]>10)&&(mmaxp[i-1]-mminp[i-1]>2)) p++;
    }
    
    //compute the median height of a letter
    int[] hig=new int[p];
    p=0;
    for (int i=0; i<k-1; i++){
      if ((jmax[i]-jmin[i]>10)&&(mmaxp[i]-mminp[i]>2)) {
        hig[p]=jmax[i]-jmin[i];
        p++;
      }
    }
    insertionSort(hig);
    int median=hig[(int)(p/ 2)];
    
    //find the areas of the letters
    int[] area=new int[k-1];
    for (int j=0; j<a.length; j++){
      for (int m=0; m<a[0].length; m++){
        for (int i=1; i<k; i++){
          if (a[j][m]==i) area[i-1]++;
        }
      }
    }
    
    int[] arord=new int[k-1];
    for (int i=0; i<k-1; i++){
      arord[i]=area[i];
    }
    insertionSort(arord);
    double threshi=0.25*arord[(k-1)/2];
    //count how many objects are definitely not letters
    int count=0;
    double threshhold=(double) median/2.0;
    for (int i=0; i<k-1; i++){
      if ((jmax[i]-jmin[i]<threshhold)||(jmax[i]-jmin[i]>4*median)||(mmaxp[i]-mminp[i]<=2)||area[i]<threshi) count++;
    }
    
    //create an array of letters
    Letter[] letters=new Letter[k-1-count];
    int c=0; 
    int[] jmax1=new int[k-1-count];
    int[] jmin1=new int[k-1-count];
    int[] mmin1=new int[k-1-count];
    int[] mmax1=new int[k-1-count];
    for (int i=1; i<k; i++){
      if ((jmax[i-1]-jmin[i-1]>=threshhold)&&(jmax[i-1]-jmin[i-1]<=4*median)&&(mmaxp[i-1]-mminp[i-1]>2)&&(area[i-1]>=threshi)){
        //find out the maximum and minimum coordinates of each letter
        mmin[i-1]=w;
        int mmax=0;
        for (int j=0; j<h; j++){
          for (int m=0; m<w; m++){
            if ((a[j][m]==i)&&(m<mmin[i-1])) 
              mmin[i-1]=m;
            if ((a[j][m]==i)&&(m>mmax)) mmax=m;
          }
        }
        
        //create a smaller matrix just fitting the letter
        int[][] x=new int[jmax[i-1]-jmin[i-1]+1][mmax-mmin[i-1]+1];
        
        //put 1's where the letter's pixels were
        for (int j=0; j<h; j++){
          for (int m=0; m<w; m++){
            if (a[j][m]==i) {
              x[j-jmin[i-1]][m-mmin[i-1]]=1;
            }
          }
        }
        
        letters[c]=new Letter(x);
        jmax1[c]=jmax[i-1];
        jmin1[c]=jmin[i-1];
        mmin1[c]=mmin[i-1];
        mmax1[c]=mmaxp[i-1];
        c++;
      }
    }
    
    
    int b=0;
    int r=0;
    
    //sort the letters
    for (int i=0; i<letters.length-1; i++){
      if (jmax1[i]<jmin1[i+1]) {
        //sort the objects on the same line so that they are in the right order
        quicksortgen(letters, b, i, mmin1,mmax1,jmin1,jmax1);
        b=i+1;
        r++;
      }
    }
    quicksortgen(letters, b, k-2-count, mmin1,mmax1,jmin1,jmax1);
    //count the letters on first row
    
    int[] spwidth=new int[letters.length-1];
    for (int i=0; i<letters.length-1; i++){
      int loff;
      int roff;
      int gap;
      int numrows;
       int min=100000000;
      loff=Math.max(jmin1[i],jmin1[i+1])-jmin1[i];
      roff=Math.max(jmin1[i],jmin1[i+1])-jmin1[i+1];
      numrows=Math.min(jmax1[i],jmax1[i+1])-Math.max(jmin1[i],jmin1[i+1])+1;
      gap=mmin1[i+1]-mmax1[i]-1;
      for (int j=0; j<numrows; j++){
        int w1=0;
        int w2=0;
        while (letters[i].get(j+loff,letters[i].getmat()[0].length-1-w1)!=1){
          w1++;
        }
        while (letters[i+1].get(j+roff, w2)!=1){
          w2++;
        }
        if (min>w1+w2+gap) min=w1+w2+gap;
      }
      spwidth[i]=min;
    }
    
    int[] spordered=new int[spwidth.length];
    for (int i=0; i<spwidth.length; i++){
      spordered[i]=spwidth[i];
      
    }
    
    insertionSort(spordered);
    double thresh=2*spordered[(letters.length-2)/2];
    //create the queue
    Queue q=new Queue();
    //add the elements of the array to it
    for (int i=0; i<letters.length; i++){
      Node n=new Node(letters[i]);
      q.add(n);
    }
    //insert blank nodes where appropriate
    int j=0;
    for (int i=0; i<letters.length-1; i++){
      if (spwidth[i]>thresh){
        int[][] blank=new int[40][50];
        Letter blanklet=new Letter(blank,' ');
        Node n=new Node(blanklet);
        q.insert(j, n);
        j++;
      }
      j++;
    }
    //count how many nodes there are in the queue
    k=1;
    Node x=q.first;
    while (x.next!=null){
      x=x.next;
      k++;
    }
    
    x=q.first;
    Letter[] letmod=new Letter[k];
    for (int i=0; i<k; i++){
      letmod[i]=x.let;
      x=x.next;
    }
    return letmod;
  }
  
  public static Letter scale(Letter a,int H, int W){
    int h=a.height();
    int w=a.width();
    int[][] m=new int[H][W];
    for (int i=0; i<H; i++){
      for (int j=0; j<W; j++){
        double x=(h*i)/H;
        double y=(w*j)/W;
        int ii=(int) Math.round(x);
        int jj=(int) Math.round(y);
        if ((ii>=0)&&(ii<h)&&(jj>=0)&&(jj<w))
          m[i][j]=a.get(ii,jj);
      }
    }
    return new Letter(m, a.character());
  }
  
  
  public static int compare(Letter a, Letter r){
    int dif=0;
    for (int i=0; i<a.height(); i++){
      for (int j=0; j<a.width(); j++){
        int x=a.get(i,j);
        int y=r.get(i,j);
        if (x!=y) dif++;
      }
    }
    return dif;
  }
  
  public static double[][] correlation(Letter[] letters, Letter[] reference,double c, double alpha){
    int H=reference[0].height();
    int W=reference[0].width();
    //scale the letters
    for (int i=0; i< letters.length; i++){
      letters[i]=scale(letters[i], H, W);
    }
    
    double[][] prob=new double[letters.length][reference.length];
    //compare each letter to the database
    for (int i=0; i<letters.length; i++){
      
      for (int j=0; j<reference.length; j++){
        int dif=compare(letters[i], reference[j]);
        prob[i][j]=1.0/dif;
        prob[i][j]=c*Math.pow(prob[i][j],alpha);
      }
    }
    
    return prob;
  }
  
  public static int area(Letter a){
    int[][] mat=a.getmat();
    int c=0;
    for (int i=0; i<mat.length; i++){
      for (int j=0; j<mat[0].length; j++){
        if (mat[i][j]==0) c++;
      }
    }
    return c;
  }
  
  public static double maxim(double[] a){
    double max=0;
    for (int i=0; i<a.length; i++){
      if (max<a[i]) max=a[i];
    }
    return max;
  }
  
  public static Seq maximum(Seq[] a){
    double max=0;
    String s="";
    for (int i=0; i<a.length; i++){
      if (max<a[i].prob()){
        max=a[i].prob();
        s=a[i].s();
      }
    }
    return new Seq(max, s);
  }
  
  
  public static void main(String[] args){
    In in1=new In("handdata.txt");
    //read the database file
    int N=in1.readInt();
    int h=in1.readInt();
    int w=in1.readInt();
    Letter[] reference=new Letter[N];
    for (int i=0; i<N; i++){
      String c=in1.readString();
      int[][] m=new int[h][w];
      for (int j=0; j<h; j++){
        String x=in1.readString(); 
        for (int k=0; k<w; k++){
          m[j][k]=Integer.parseInt(x.substring(k, k+1));   
          
        }
      }
      reference[i]=new Letter(m, c.charAt(0));
    }
    
    String file=args[0];
    In in2=new In(file);
    String st=in2.readAll();
    //create the probability matrix
    double[][] mark=new double[reference.length][reference.length];
    
    for (int i=0; i<reference.length; i++){
      for (int j=0; j<reference.length; j++){
        mark[i][j]=.0001;
      }
    }
    for (int i=0; i<st.length()-1; i++){
      int m=-1;
      int n=-1;
      int p=-1;
      int q=-1;
      int m1=-1;
      int n1=-1;
      int p1=-1;
      int q1=-1;
      char u=Character.toUpperCase(st.charAt(i));
      char v=Character.toUpperCase(st.charAt(i+1));
      char x=Character.toLowerCase(st.charAt(i));
      char y=Character.toLowerCase(st.charAt(i+1));
      for (int j=0; j<reference.length; j++){
        if ((u==reference[j].character())&&(m<0)) m=j;
        else if (u==reference[j].character()) m1=j;
        if ((v==reference[j].character())&&(n<0)) n=j;
        else if (v==reference[j].character()) n1=j;
        if ((x==reference[j].character())&&(p<0)) p=j;
        else if (x==reference[j].character()) p1=j;
        if ((y==reference[j].character())&&(q<0)) q=j;
        else if (y==reference[j].character()) q1=j;
      }
      
      if ((m>=0)&&(n>=0)) mark[m][n]++;
      if ((m>=0)&&(q>=0)) mark[m][q]++;
      if ((p>=0)&&(q>=0)) mark[p][q]++;
      if ((p>=0)&&(n>=0)) mark[p][n]++;
      if ((p>=0)&&(n>=0)) mark[m1][n]++;
      if ((p>=0)&&(n>=0)) mark[m1][q]++;
      if ((p>=0)&&(n>=0)) mark[m][n1]++;
      if ((p>=0)&&(n>=0)) mark[m][q1]++;
      if ((p>=0)&&(n>=0)) mark[p1][q]++;
      if ((p>=0)&&(n>=0)) mark[p1][n]++;
      if ((p>=0)&&(n>=0)) mark[p][q1]++;
      if ((p>=0)&&(n>=0)) mark[m1][n1]++;
      if ((p>=0)&&(n>=0)) mark[m1][q1]++;
      if ((p>=0)&&(n>=0)) mark[p1][q1]++;
      if ((p>=0)&&(n>=0)) mark[p][n1]++;
      if ((p>=0)&&(n>=0)) mark[p1][n1]++;
      
      
    }
    
    for (int i=0; i<reference.length; i++){
      double sum=0;
      for (int j=0; j<reference.length; j++){
        sum=sum+mark[i][j];
      }
      if (sum!=0){ for (int j=0; j<reference.length; j++){
        mark[i][j]=mark[i][j]/sum;
      }
      }
    }
    
    
    //read the file to be scanned
    String file1=args[1];
    Picture pic=new Picture(file1);
    pic.show();
    Picture pic2=blackwhite(file1);
    pic2.show();
    //create a matrix of the same dimension as the picture, storing
    //the labels that say to which object each pixel corresponds 
    int[][] a=new int[pic2.height()][pic2.width()];
    int k=1;
    Stack s=new Stack();                  
    
    //floodfill until every pixel has been visited
    for (int i=0; i<pic2.height(); i++){
      for (int j=0; j<pic2.width(); j++){  
        if (a[i][j]==0) {
          Color c=pic2.get(j,i);
          if (c.equals(Color.BLACK)) {
            s.push(i,j);
            floodfillstack(pic2, a, s, c,k);      
            k++;
          }
        }
      }
    }
    
    //genereate the array of letters
    Letter[] letters=extract(a,pic.height(),pic.width(),k);
    
    //generate the probability matrix
    double c1=Double.parseDouble(args[2]);
    double alpha=Double.parseDouble(args[3]);
    double[][] prob=correlation(letters, reference, c1, alpha);
    
    //create a matrix whose elements are of class Seq (consisting of a probability of a certain sequence occuring
    //and the string-the respective sequence
    int b=0;
    for (int i=0; i<letters.length; i++){
      if (letters[i].character()==' ') {
        Seq[][] delta=new Seq[i-b][reference.length];
        for (int i1=0; i1<reference.length; i1++){
          char c=reference[i1].character();
          delta[0][i1]=new Seq(prob[b][i1], ""+c);
        }
        
        for (int i1=b+1; i1<i; i1++){
          for (int j=0; j<reference.length; j++){
            Seq[] array=new Seq[reference.length];
            for (int m=0; m<reference.length; m++){
              char c=reference[j].character();
              String str=delta[i1-b-1][m].s()+c;
              array[m]=new Seq(delta[i1-b-1][m].prob()*prob[i1][j]*mark[m][j], str);
            }
            delta[i1-b][j]=maximum(array);
            
          }
        }
        
        Seq sequence=maximum(delta[i-b-1]);
        System.out.print(sequence.s()+" ");
        b=i+1;
        
      }
    }
  
    //need to do it again outside the for loop to get the last word
    Seq[][] delta=new Seq[letters.length-b][reference.length];
    for (int i1=0; i1<reference.length; i1++){
      char c=reference[i1].character();
      delta[0][i1]=new Seq(prob[b][i1], ""+c);
    }
    
    for (int i1=b+1; i1<letters.length; i1++){
      for (int j=0; j<reference.length; j++){
        Seq[] array=new Seq[reference.length];
        for (int m=0; m<reference.length; m++){
          char c=reference[j].character();
          String str=delta[i1-b-1][m].s()+c;
          array[m]=new Seq(delta[i1-b-1][m].prob()*prob[i1][j]*mark[m][j], str);
        }
        delta[i1-b][j]=maximum(array);
        
      }
    }
    Seq sequence=maximum(delta[letters.length-b-1]);
    System.out.println(sequence.s()+" ");
  }
}