class Solution {
    public int characterReplacement(String s, int k) {
        int best = 0;

        char[] sChar = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int maxFreq = 0;
        while (end < sChar.length) {

            // add right
            if (map.containsKey(sChar[end])) {
                map.put(sChar[end], map.get(sChar[end]) + 1);
            } else {
                map.put(sChar[end], 1);
            }
            maxFreq = Math.max(maxFreq, map.get(sChar[end]));

            // check if its invalid, if so, remove until valid
            while (end - start + 1 - maxFreq > k) {
                map.put(sChar[start], map.get(sChar[start]) - 1);
                start++;
            }

            // record answer
            best = Math.max(best, end - start + 1);
            // move right
            end++;
        }
        return best;
    }
}
