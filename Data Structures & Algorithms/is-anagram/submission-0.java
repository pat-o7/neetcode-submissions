class Solution {
    public boolean isAnagram(String s, String t) {
        // check strings are the same length
        if (!(s.length() == t.length())) {
            return false;
        }

        // create map
        HashMap<Character, Integer> map = new HashMap<>();

        // iterate through s and store letters in map
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        // iterate through t and decrement map
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) > 0) {
                // decrement if count is > 0
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                } else {
                    return false;
                }
            } else {
                // does not contain key
                return false;
            }

        }
        return true;
    }
}
