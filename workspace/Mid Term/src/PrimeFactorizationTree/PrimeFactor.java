
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
package PrimeFactorizationTree;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class PrimeFactor {
	private static final Random random = new Random();
	private int value;

	private int[] factories = new int[32];
	private int size;

	public PrimeFactor(int v) {
		super();
		if(v<0)
		{
			 JOptionPane.showMessageDialog(null,"Positives please","ERROR",
					  JOptionPane.ERROR_MESSAGE);}
		
		this.value = v;
	}

	public int[] getFactories() {
		compute();
		int[] ret = new int[size];
		System.arraycopy(factories, 0, ret, 0, size);
		return ret;
	}

	private void compute() {
		if (size > 0) {
			return;
		}

		int t = value;
		int max = (int) (t / 2);
		for (int i = 2; i <= max; i++) {
			while (true) {
				if (t % i == 0) {
					factories[size++] = i;
					t = t / i;
				} else {
					break;
				}
			}
		}
		if (size == 0) {
			factories[0] = value;
			size = 1;
		}
	}

	private void add(int v) {
		this.factories[size++] = v;
		this.value *= v;
	}

	public int getValue() {
		return value;
	}

	public PrimeFactor[] getMultiplicator() {
		this.compute();
		if (size == 1) {
			return null;
		}

		PrimeFactor left = new PrimeFactor(1);
		PrimeFactor right = new PrimeFactor(1);

		int seed = nextRandom();
		for (int i = 0; i < size; i++) {
			if ((seed & (1 << i)) > 0) {
				left.add(this.factories[i]);

			} 
			else 
			{
				right.add(this.factories[i]);
			}
		}

		return new PrimeFactor[] { left, right };

	}

	private int nextRandom() {
		int max = (int) Math.pow(2, size) - 1;
		int seed;
		do {
			seed = random.nextInt(max) + 1;
		} while (seed == max);

		return seed;
	}

	public String toString() {
		compute();
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		sb.append(" = ");
		for (int i = 0; i < size; i++) {
			sb.append(this.factories[i]);
			if (i < size - 1) {
				sb.append(" * ");
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		for (int i = 1; i < 199; i++) {
			System.out.println(new PrimeFactor(i));
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(Arrays.toString(new PrimeFactor(126)
					.getMultiplicator()));
		}
	}

}
