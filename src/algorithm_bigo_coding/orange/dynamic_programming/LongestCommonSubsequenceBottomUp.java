package algorithm_bigo_coding.orange.dynamic_programming;

import java.util.Arrays;

public class LongestCommonSubsequenceBottomUp {
	private static final int MAXN = 100;
	private static final int MAXM = 100;
	private static int[][] dp = new int[MAXN+1][MAXM+1];
	
	private static int LCS(String s1, String s2, int m, int n) {
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				
				else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				
				else 
				dp[i][j] = Math.max(dp[m-1][n], dp[m][n-1]);
			}
		}
		
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
