class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return dfs(coins, 0, amount, dp);
    }
    int dfs(int[] coins, int i, int amount, Integer[][] dp) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) return 0;
        if (dp[i][amount] != null) return dp[i][amount];
        int ans = 0;
        ans += dfs(coins, i + 1, amount, dp); // skip ith coin
        ans += dfs(coins, i, amount - coins[i], dp); // use ith coin
        return dp[i][amount] = ans;
    }
}