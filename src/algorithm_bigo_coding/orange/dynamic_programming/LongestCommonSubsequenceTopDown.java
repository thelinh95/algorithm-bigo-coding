package algorithm_bigo_coding.orange.dynamic_programming;

import java.util.Arrays;

public class LongestCommonSubsequenceTopDown {
	private static final int MAXN = 100;
	private static final int MAXM = 100;
	private static int[][] dp = new int[MAXN+1][MAXM+1];
	
	private static int LCS(String s1, String s2, int m, int n) {
		if(m==0 || n==0) {
			dp[m][n] = 0;
			return 0;
		}
		
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		
		// get character at position m of s1
		// compare with character at position n of s2 
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			dp[m][n] = 1 + LCS(s1, s2, m-1, n-1);
			return dp[m][n];
		}
		
		dp[m][n] = Math.max(LCS(s1, s2, m-1, n), LCS(s1, s2, m, n-1));
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		
		String s1 = "ATCJDZEFGY";
		String s2 = "BADCJEFGYT";
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
			
		}
		
		System.out.printf("Length of LCS is %d\n",
				LCS(s1, s2, s1.length(), s2.length()));
	}
}
