class Solution {
    public boolean isPalindrome(String s) {

        String cleaned = s.toLowerCase();
        cleaned = cleaned.replaceAll("[^a-zA-Z0-9]", ""); //wasitacaroracatisaw

        char[] cleanedChars = cleaned.toCharArray();
        

        int left = 0;
        int right = cleanedChars.length - 1;

        while (left < right) {
            System.out.println("left: " + cleanedChars[left] + " | right: " + cleanedChars[right]);
            if (!(cleanedChars[left] == cleanedChars[right])) {
                return false;
            }

            left++;
            right--;
        }

        return true;        
    }
}
