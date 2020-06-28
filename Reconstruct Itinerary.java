class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String s1 = ticket.get(0);
            String s2 = ticket.get(1);
            graph.putIfAbsent(s1, new ArrayList<>());
            graph.get(s1).add(s2);
        }
        for (List<String> neibs : graph.values()) {
            Collections.sort(neibs);
        }
        ans.add("JFK");
        backTrack("JFK", graph, ans, tickets.size() + 1);
        return ans;
    }
    public boolean backTrack(String cur, Map<String, List<String>> graph, List<String> ans, int n) {
        if (ans.size() == n) return true;
        List<String> neibs = graph.get(cur);
        if (neibs == null || neibs.isEmpty()) return false;
        int size = neibs.size();
        for (int i = 0; i < size; i++) {
            String neib = neibs.remove(i);
            ans.add(neib);
            if (backTrack(neib, graph, ans, n)) return true;
            ans.remove(ans.size() - 1);
            neibs.add(i, neib);
        }
        return false;
    }
}