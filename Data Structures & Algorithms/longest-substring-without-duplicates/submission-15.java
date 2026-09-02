class Solution {
    public int lengthOfLongestSubstring(String s) {
        int best = 0;

        // turn string into char array
        char[] sChar = s.toCharArray();

        // create hashset to store characters in window
        Set<Character> set = new HashSet<>();

        // iterate through substring with a sliding window
        int start = 0;
        int end = 0;
        while (end < sChar.length) {
            // if its valid, add character
            if (!set.contains(sChar[end])) {
                set.add(sChar[end]);
                end++;
                best = Math.max(best, end - start);
            } else {
                set.remove(sChar[start]);
                start++;
            }

            // if its invalid, subtract character
        }



        return best;        
    }
}
