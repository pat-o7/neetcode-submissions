class Solution {
    public boolean isPalindrome(String s) {

        String string = s.toLowerCase();
        char[] chars = string.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!(Character.isLetter(chars[left]) || Character.isDigit(chars[left]))) {
                left++;
                continue;
            }
            if (!(Character.isLetter(chars[right]) || Character.isDigit(chars[right]))) {
                right--;
                continue;
            }

            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;        
    }
}
