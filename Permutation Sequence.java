class Solution {
    String ans=new String();
    int count=0;
    public String getPermutation(int n, int k) {
        if(n==1) return new String("1");
        boolean visited[] = new boolean[n+1];
        recurse("", visited,n,k);
        return ans;       
    }
    public void recurse(String string, boolean visited[], int n,int k){
        if(ans.length()==n) return;
        if(string.length() == n && count == k-1){ 
            ans = string;
            return;
        }
        if(string.length() == n){
            count++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(visited[i] == false){
                visited[i] = true;
                recurse(string+Integer.toString(i), visited, n, k);
                visited[i] = false;
            }
        }
    }
}