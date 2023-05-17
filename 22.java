class Solution {
    // class Node {
    //     String value;
    //     int leftBracket;
    //     int rightBracket;
    //     Node left;
    //     Node right;

    //     Node() {
    //         this.value = "";
    //         this.right = null;
    //         this.left = null;
    //     }
    // }

    List<String> l;

    public List<String> generateParenthesis(int n) {
        this.l = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return this.l;
    }
    
    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            this.l.add(s);
            return;
        }
        
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
}