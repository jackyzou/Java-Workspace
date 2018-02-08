import java.util.Scanner;
public class PrimeNumber {

public static boolean isPrime(int num) {
boolean prime = true;
int limit = (int) Math.sqrt(num);
for (int i = 2; i <= limit; i++) {
if (num % i == 0) {
prime = false;
break;
}
}
return prime;
}
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.print("type in£º");
int n = input.nextInt();
if (isPrime(n)) {
System.out.println(n + " is prime£¡");
} else {
System.out.println(n+ " is not a prime£¡");
}
}
}
