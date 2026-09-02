class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        int bestResultLength = Integer.MAX_VALUE;

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < tChar.length; i++) {
            if (need.containsKey(tChar[i])) {
                need.put(tChar[i], need.get(tChar[i]) + 1);
            } else {
                need.put(tChar[i], 1);
            }
        }

        int start = 0;
        int end = 0;
        int satisfied = 0;
        int total = need.size();
        while (end < sChar.length) {
            // add right
            if (have.containsKey(sChar[end])) {
                have.put(sChar[end], have.get(sChar[end]) + 1);
            } else {
                have.put(sChar[end], 1);
            }
            if (need.containsKey(sChar[end]) && have.get(sChar[end]).equals(need.get(sChar[end]))) {
                satisfied++;
            }


            // check if valid
            while (satisfied == total) {
                // record window
                if (end - start + 1 < bestResultLength) {
                    result = s.substring(start, end + 1);
                    bestResultLength = end - start + 1;
                }
                // move until invalid
                if (have.containsKey(sChar[start])) {
                    have.put(sChar[start], have.get(sChar[start]) - 1);
                }
                if (need.containsKey(sChar[start]) && have.get(sChar[start]) < need.get(sChar[start])) {
                    satisfied--;
                }
                start++;
            }


            // move right
            end++;
        }

        return result;

        
    }
}
