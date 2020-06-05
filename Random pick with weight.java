class Solution {

Random rand;
    int[] a;
    public Solution(int[] w) {
        rand = new Random();
        for(int i = 1; i < w.length; i++) w[i] += w[i-1];
        a = w;
    }
    
    public int pickIndex() {
        int idx = Arrays.binarySearch(a, rand.nextInt(a[a.length-1]) + 1);
        if(idx < 0) idx = -idx-1;
        return idx;
    }}

