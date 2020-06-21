class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for(int i = 0; i < dungeon.length + 1; i++) Arrays.fill(dp[i], -1);
       
        return mhr(dungeon, 0, 0, dp);
    }
   
    int mhr(int[][] arr, int i, int j, int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        if(i == arr.length - 1 && j == arr[0].length - 1) return arr[i][j] > 0 ? 1 : Math.abs(arr[i][j]) + 1;
        if(i == arr.length || j == arr[0].length) return Integer.MAX_VALUE;
       
        return dp[i][j] = Math.max(1, Math.min(mhr(arr, i + 1, j, dp), mhr(arr, i, j + 1, dp)) - arr[i][j]);
    }
   
}