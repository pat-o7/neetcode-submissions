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
            char letter = s.charAt(i);
            if (map.containsKey(s.charAt(i))) {
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }

        // iterate through t and decrement map
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            if (map.containsKey(letter)) {
                if (map.get(t.charAt(i)) > 0) {
                // decrement if count is > 0
                map.put(letter, map.get(letter) - 1);
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
