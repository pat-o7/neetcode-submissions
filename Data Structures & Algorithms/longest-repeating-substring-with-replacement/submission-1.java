class Solution {
    public int characterReplacement(String s, int k) {
        int best = 0;
        char[] string = s.toCharArray();

        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabet = alphabetString.toCharArray();

        for (char letter : alphabet) {
            int left = 0;
            int right = 0;

            int nonLetterCount = 0;

            while (right < string.length) {
                    if (string[right] == letter) {
                    } else {
                        nonLetterCount++;

                        if (nonLetterCount > k) {
                            while (left <= right && nonLetterCount > k) {
                                if (string[left] != letter) {
                                    nonLetterCount--;
                                }
                                left++;
                            }
                        }

                    }
                    best = Math.max(best, right - left + 1);
                    right++;
            }
        }
        return best;
    }
}
