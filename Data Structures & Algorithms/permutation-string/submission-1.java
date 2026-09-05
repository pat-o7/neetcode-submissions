class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] s1Char = s1.toCharArray();
        Arrays.sort(s1Char);
        char[] s2Char = s2.toCharArray();

        int left = 0;
        int right = s1.length();
        while (right <= s2Char.length) {
            char[] temp = s2.substring(left, right).toCharArray();
            Arrays.sort(temp);
            if (Arrays.equals(temp, s1Char)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
