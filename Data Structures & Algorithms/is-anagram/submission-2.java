class Solution {
    public boolean isAnagram(String s, String t) {

        if (!(s.length() == t.length())) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        

        // create frequency map
        HashMap<Character, Integer> map = new HashMap<>();

        // iterate through s
        for (int i = 0; i < charS.length; i++) {
            // exists in map
            if (map.containsKey(charS[i])) {
                map.put(charS[i], map.get(charS[i]) + 1);

                // dne in map
            } else {
                map.put(charS[i], 1);
            }
        }

        // iterate through t
        for (int i = 0; i < charT.length; i++) {
            // exists in map
            if (map.containsKey(charT[i])) {
                map.put(charT[i], map.get(charT[i]) - 1);

                if (map.get(charT[i]) < 0) {
                    return false;
                }

                // dne
            } else {
                return false;
            }
        }

        return true;



    }
}
