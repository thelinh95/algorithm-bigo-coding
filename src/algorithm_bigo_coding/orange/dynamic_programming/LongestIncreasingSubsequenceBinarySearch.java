package algorithm_bigo_coding.orange.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequenceBinarySearch {
	private static int LIS(int[] a) {
		int length = 1;
		List<Integer> dp = new ArrayList<Integer>();
		dp.add(0);
		
		int[] path = new int[a.length];
		Arrays.fill(path, -1);
		
		for(int i=1; i< a.length; i++) {
			
			if(a[i] >a[dp.get(length-1)]) {
				path[i] = dp.get(length-1);
				dp.add(i);
				length++;
			} else {
				int pos = lowerBound(a, dp, length, a[i]);
				path[i] = dp.get(pos-1);
				dp.set(pos, i);
			}
			
		}
		
		return length;
	}
	
	private static int lowerBound(int[] a, List<Integer> dp,
			int n, int x) {
		
		int left = 0, right = n;
		int pos = n;
		while(left < right) {
			int mid = left + ( right -left)/2;
			int index = dp.get(mid);
			if(a[index] >= x) {
				pos = mid;
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		int[] a = new int[] {
				2, 5, 12, 3, 10, 6, 8, 14, 4, 11, 7, 15};
		
		
		System.out.print("Longest increasing subsequence is: ");
		int result= LIS(a);
		
		
		System.out.print(result);
		
	}
	
}
