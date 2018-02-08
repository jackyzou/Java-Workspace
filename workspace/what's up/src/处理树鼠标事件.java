public class 处理树鼠标事件 {

 public static void main(String[] args) {
  System.out.println(factorialSum(20));

  primeNumber(1,1000);
}

//2．求r到n之间所有的素数。
 public static void primeNumber(int begin,int end){
  
  if(begin <= 1 || end <= 1){
   return;
  }
  
  for(int i=begin; i<=end; i++){
   int count = 0;
   for(int j=2; j<i; j++){
    if(i%j == 0){
     count++;
    }
   }
   if(count == 0){
    System.out.println(i);
   }
  }
  
 } 
//1!+2!+3!+…+N!
 public static long factorialSum(int n){
  long sum = 0l;
  if(n<0){
   return sum;
  }
  for(int i=1;i<=n;i++){
   sum += factorial(i);
  }
  
  return sum;
 }
 
 //N!
 public static long factorial(int n){
  long result = 1l;
  
  if(n<=0){
   return 0;
  }
  
  for(int i=1;i<=n;i++){
   result *=i;
  }
  
  return result;
 }

}
