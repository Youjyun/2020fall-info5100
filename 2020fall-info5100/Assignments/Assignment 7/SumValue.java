import java.util.Random;

public class SumValue extends Thread {
	private static final Random RAND = new Random(); // random number generator
	
	private int[] arr;
	private int low, high, partial;

	public SumValue(int[] arr, int low, int high) {
		this.arr = arr;
		this.low = low;
		this.high = Math.min(high, arr.length);
	}

	public int getPartialSum() {
		return partial;
	}

	public void run() {
		partial = sum(arr, low, high);
	}

	public static int sum(int[] arr, int low, int high) {
		int total = 0;

		for (int i = low; i < high; i++) {
			total += arr[i];
		}
		return total;
	}

	/* generate array of random numbers */
	static int[] generateRandomArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = RAND.nextInt();
		}
		return arr;
	}

	/* get sum of an array using 4 threads */
	static long sum(int[] arr) {
		int size = (int) Math.ceil(arr.length * 1.0 / 4);

		SumValue[] sums = new SumValue[4];

		for (int i = 0; i < 4; i++) {
			sums[i] = new SumValue(arr, i * size, (i + 1) * size);
			sums[i].start();
		}

		try {
			for (SumValue sum : sums) {
				sum.join();
			}
		} catch (InterruptedException e) {
		}

		int total = 0;

		for (SumValue sum : sums) {
			total += sum.getPartialSum();
		}

		return total;
	}

	public static void main(String[] args) {
		int[] arr = new int[4000000];
		arr = generateRandomArray(arr);
		long sum = sum(arr);
		System.out.println("Sum: " + sum);
	}
}