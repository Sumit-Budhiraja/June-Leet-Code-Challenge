class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y) -> x[0]!=y[0] ? x[0]-y[0] : x[1]-y[1]);
        for(int[] person: people) queue.offer(person);
        int[][] result = new int[people.length][];
        while(!queue.isEmpty()) {
            int[] person = queue.poll();
            for(int i=0, aheadCount = 0;i<result.length;i++) {
                if(aheadCount == person[1] && result[i] == null) {
                    result[i] = person;
                    break;
                }
                if(result[i] == null || result[i][0] == person[0]) aheadCount++;
            }
        }
        return result;
    }
}