package Multiplication;
//mutiple, 2 varible, give two int, two mutiply,
public class MultiplyObject {

	private int firstValue;//instance variables~object's data
	private int secondValue;
	private int result;
	
	public MultiplyObject(int first, int second)
	{
		firstValue = first;//�������������������������int ���ֺ����һ�����Ǿ���this.firstValue=firstValue
		secondValue = second;
	}
	
	public void product()
	{
		 result = firstValue * secondValue;
	}
	
	public void printProduct()
	{
	System.out.println("The product of"+" " + firstValue +" "+ "and"+" "+secondValue +" "+ "is"+" " + result);
	}
}
