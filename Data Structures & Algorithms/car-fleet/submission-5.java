class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int result = 1;

        if (position.length == 1) {
            return result;
        }

        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> {
            if (a[0] > b[0]) {
                return -1;
            } else if (a[0] < b[0]) {
                return +1;
            } else {
                return 0;
            }
        });

        // sorted cars array by position
        double lastTime = (double) (target - cars[0][0]) / cars[0][1];
        for (int i = 1; i < cars.length; i++) {

            // see if this car can reach the next car by the destination
            double currTime = (double) (target - cars[i][0]) / cars[i][1]; 
            if (currTime <= lastTime) {
                // reaches in one fleet, OK
            } else {
                // needs new fleet
                result++;
                // update lastTime
                lastTime = currTime;                
            }
        }
        return result;        
    }
}
