///////////////////////////Jacky's project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////Jacky's project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

public class NewtonIteration{
   private static final NewtonIteration Rabbit = null;


public static void squareRoot(String[] args){
    //change the number inside of print.

    Rabbit.squareRoot(10000);

}


public static double squareRoot(double n){
double x =1;
double temp =1;
do{
temp = x;
x = 0.5*(x + n/x);
}while(Math.abs(x - temp)>0.000001);
System.out.printf("%.3f��ƽ����Ϊ��%.3f",n,x); //��ӡn������ƽ����
return x;
}
}