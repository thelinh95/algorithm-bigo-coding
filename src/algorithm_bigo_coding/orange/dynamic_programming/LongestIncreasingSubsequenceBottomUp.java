package algorithm_bigo_coding.orange.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequenceBottomUp {
	public static int LIS(int[] a) {
		int l = a.length;
		
		int[] path = new int[l];
		Arrays.fill(path, -1);
		List<Integer> dp = new ArrayList<Integer>();
	
		for(int i = 0; i<l; i++) {
			dp.add(1);
		}
		
		for(int i=1; i < l; i++) {
			for(int j=0; j<i; j++) {
				if(a[i] > a[j] && dp.get(i) < (dp.get(j) +1)) {
					dp.set(i, dp.get(j) + 1);
					path[i] = j;
				}
			}
		}
		
		return dp.stream().max(Comparator.comparingInt(i -> i)).get();
		
	}
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(LongestIncreasingSubsequenceBottomUp.class.getResourceAsStream("longest_increasing_subsequence.txt"))) {
			ArrayList<Integer> inputArr = new ArrayList<Integer>();
			while(scanner.hasNext()) {
				inputArr.add(scanner.nextInt());
			}
			
			int[] a= inputArr.stream().mapToInt(j -> j).toArray();
			int result = LIS(a);
			System.out.print(result);
		}
	}
	
}
