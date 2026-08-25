class Solution {

    public String encode(List<String> strs) {
        int count = strs.size();
        String result = "";

        // if (strs.isEmpty()) {
        //     return "";
        // }


        for (String string : strs) {
            int length = string.length();
            result = result + length + "#" + string;
        }

        return result;
    }

    // 5#Hello5#World

    // "4#HELL5#WORLD#2#OK"

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j)); // 4
            String word = str.substring(j + 1, j + 1 + length);
            // 2, 6
            result.add(word);
            i = j + 1 + length;
        }


        // char[] strChars = str.toCharArray();

        // int pointer = 0;

        // String strLength = "";
        // int intLength = 0;
        // String currWord = "";

        // boolean counting = true;

        // for (int i = 0; i < strChars.length; i++) {

        //     if (counting) {
        //         if (strChars[i] != '#') {
        //             strLength = strLength + strChars[i];
        //         } else {
        //             intLength = Integer.parseInt(strLength);
        //             strLength = "";
        //             counting = false;
        //         }
        //     } else {
        //         if (intLength > 0) {
        //             currWord = currWord + strChars[i];
        //             intLength--;
        //             if (intLength == 0) {
        //                 result.add(currWord);
        //                 counting = true;
        //                 currWord = "";
        //             }
        //         } else {

        //         }
        //     }
        // }
        return result;
    }
}
