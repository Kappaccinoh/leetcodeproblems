class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet set = new HashSet();
        for (List<Integer> item : edges) {
            set.add(item.get(1));
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

}