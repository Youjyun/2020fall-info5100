/**
 * The deadline of this assignment is 09/25/2020 23:59 PST. Please feel free to
 * contact Yafei and Yaqi for any questions.
 */

public class Assignment2_2 {
	/**
	 * Given an integer array nums, find the contiguous subarray (containing at
	 * least one number) which has the largest sum and outprint its sum.
	 *
	 * Example 1: Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation:
	 * [4,-1,2,1] has the largest sum = 6.
	 *
	 * Example 2: Input: nums = [1] Output: 1
	 */
	public int maxSubArray(int[] nums) {
		int res = Integer.MIN_VALUE;
		int curSum = 0;
		for (int num : nums) {
			curSum = Math.max(curSum + num, num);
			if (curSum > res) {
				res = curSum;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		
		int[] nums = { -2,1,-3,4,-1,2,1,-5,4 };
		Assignment2_2 a2 = new Assignment2_2();
		System.out.println(a2.maxSubArray(nums));
	}
}