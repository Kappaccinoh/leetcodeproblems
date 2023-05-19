import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet blue = new HashSet();
        HashSet red = new HashSet();

        for (int n = 0; n < graph.length; n++) {
            if (blue.contains(n) || red.contains(n)) {
                continue;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(n);
            blue.add(n);

            while (!queue.isEmpty()) {
                int currNode = (int) queue.poll();

                for (int node : graph[currNode]) {
                    // exit conditions
                    

                    // only take uncoloured nodes
                    if (!blue.contains(node) && !red.contains(node)) {
                        if (blue.contains(currNode)) {
                            red.add(node);
                            queue.add(node);
                        } else {
                            blue.add(node);
                            queue.add(node);
                        }
                    }

                    if (blue.contains(currNode) && red.contains(currNode)) {
                        return false;
                    }

                    if (blue.contains(node) && red.contains(node)) {
                        return false;
                    }

                    if (blue.contains(node) && blue.contains(currNode)) {
                        return false;
                    }

                    if (red.contains(node) && red.contains(currNode)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}