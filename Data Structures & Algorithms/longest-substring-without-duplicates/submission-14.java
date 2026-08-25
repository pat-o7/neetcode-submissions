class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        // track longest substring seen
        int best = 0;
        int tempBest = 0;

        // left and right pointer
        int left = 0;
        int right = 0;

        // unique hashmap of letter, index
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < chars.length) {
            if (!map.containsKey(chars[right])) {
            } else {
                if (!(map.get(chars[right]) + 1 < left)) {
                    left = map.get(chars[right]) + 1;
                }
            }
                map.put(chars[right], right);
                tempBest = right - left + 1;
                best = Math.max(best, tempBest);
                right++;            
        }

        return best;        
    }
}
