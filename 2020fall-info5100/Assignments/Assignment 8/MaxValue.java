import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MaxValue extends Thread {
	private static final Random RAND = new Random(); // random number generator
	
	private int[] arr;
	private int low, high, partial;

	public MaxValue(int[] arr, int low, int high) {
		this.arr = arr;
		this.low = low;
		this.high = Math.min(high, arr.length);
	}

	public int getPartialMax() {
		return partial;
	}

	public void run() {
		partial = max(arr, low, high);
	}

	public static int max(int[] arr, int low, int high) {
		int max = Integer.MIN_VALUE;

		for (int i = low; i < high; i++) {
			max = Math.max(arr[i], max);
		}
		return max;
	}

	/* generate array of random numbers */
	static int[] generateRandomArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = RAND.nextInt();
		}
		return arr;
	}

	/* get sum of an array using 10 threads */
	static long max(int[] arr) {
		int size = (int) Math.ceil(arr.length * 1.0 / 10);

	    MaxValue[] maxs = new MaxValue[10];

		for (int i = 0; i < 10; i++) {
			maxs[i] = new MaxValue(arr, i * size, (i + 1) * size);
			maxs[i].start();
		}

		try {
			for (MaxValue max : maxs) {
				max.join();
			}
		} catch (InterruptedException e) {
		}
       
		ArrayList<Integer> maxValue = new ArrayList<Integer>() ;

		for (MaxValue max : maxs) {
			maxValue.add(max.getPartialMax());
		}
		int max =  Collections.max(maxValue);
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[100000];
		arr = generateRandomArray(arr);
		long max = max(arr);
		System.out.println("Max: " + max);
	}
}