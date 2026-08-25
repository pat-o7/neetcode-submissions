class Solution {
    public int characterReplacement(String s, int k) {
        int best = 0;
        char[] string = s.toCharArray();

        // "AAABABACDDDDBD" // 6
        // "DAAADADACDDBD" // 1: 5
        // "AABABABABBBA" // 2: 7
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabet = alphabetString.toCharArray();

        for (char letter : alphabet) {
            int left = 0;
            int right = 0;

            int letterCount = 0;
            int nonLetterCount = 0;

            while (right < string.length) {
                    if (string[right] == letter) {
                        letterCount++;
                        best = Math.max(best, right - left + 1);
                        right++;
                    } else {
                        nonLetterCount++;

                        if (nonLetterCount > k) {
                            while (left <= right) {
                                if (nonLetterCount > k) {
                                    if (string[left] == letter) {
                                        letterCount--;
                                        left++;
                                    } else {
                                        nonLetterCount--;
                                        left++;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }

                        best = Math.max(best, right - left + 1);                    
                        right++;
                    }




                
              




            }
        }
        return best;
    }
}
