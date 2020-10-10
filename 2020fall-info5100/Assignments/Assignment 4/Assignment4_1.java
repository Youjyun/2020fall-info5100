import java.util.PriorityQueue;

public class Assignment4_1 {

	public int findKthLargest(int[] num, int k) {
		PriorityQueue<Integer> miniHeap = new PriorityQueue<Integer>();
		for (int n : num) {
			miniHeap.add(n);

			if (miniHeap.size() > k) {
				miniHeap.remove();
			}
		}
		return miniHeap.remove();
	}

	public static void main(String[] args) {

		Assignment4_1 solution = new Assignment4_1();
		int[] num = { 4, 1, 6, 5, 9, 2 };
		System.out.println(solution.findKthLargest(num, 2));
	}

}
