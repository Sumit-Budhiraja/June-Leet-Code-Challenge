class Solution {
    public int numTrees(int n) {
        int[] cache = new int[n+1];
        cache[0] = cache[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int root = 0; root < i; root++) {
                int left = root;
                int right = i - 1 - left;
                cache[i] += (cache[left] * cache[right]);
            }
        }
        return cache[n];
    }
}