class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int rate = 0;
        while (min < max) {
            rate = (max + min) / 2;
            int gulps = 0;

            for (int i = 0; i < piles.length; i++) {
                gulps = gulps + Math.ceilDiv(piles[i], rate);

            }

            if (gulps > h) {
                // need to eat faster, increase rate
                min = rate + 1;
            } else {
                // it might be slower
                max = rate;
            }
        }
        return min;        
    }
}
