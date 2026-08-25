class Solution {
    public int lengthOfLongestSubstring(String s) {

        // keep track of best
        int best = 0;

        // keep a left pointer
        // keep a right pointer
        int left = 0;
        int right = 0;

        HashMap<String, Integer> map = new HashMap<>();

        int tempBest = 0;

        while (right < s.length()) {
            if (!map.containsKey(s.substring(right, right + 1))) {
                map.put(s.substring(right, right + 1), right);
                System.out.println("right: " + right + " | left: " + left);

            } else {
                left = Math.max(left, map.get(s.substring(right, right + 1)) + 1);
                map.put(s.substring(right, right + 1), right);

            }
                tempBest = right - left + 1;
                best = Math.max(best, tempBest);
                right++;            
        }

        // increment right pointer
        // store unseen letters in hashmap<letter, earliest index>
        
        // if letter is seen, it is a repeated letter
        // update left pointer to previous earliest index + 1
        // update earliest index to new index in hashmap
        return best;
    }
}
