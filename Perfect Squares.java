class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int x = 1; x <= n; ++x){
            int min_val = x;
            int y = 1, sq = 1;
            while(sq <= x){
                min_val = Math.min(min_val, 1 + dp[x-sq]);
                y++;
                sq = y*y;
            }
            dp[x] = min_val;
        }
        return dp[n];
    }
}