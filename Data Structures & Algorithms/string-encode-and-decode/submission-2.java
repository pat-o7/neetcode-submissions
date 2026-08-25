// substring(1,1) same numbers will return empty string
// 0 length case handled

// substring(a,b) the b can be 1 out of bounds

class Solution {

    public String encode(List<String> strs) {
        // encode length of string and string
        String result = "";

        for (String string : strs) {
            int length = string.length();
            result = result + length + "#" + string;
        }
        return result;
    }

    // ["Hello", "World"]
    // 5#Hello5#World

    // [""]
    // "0#"


    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + length);
            result.add(word);

            i = j + 1 + length;
        }


        return result;
    }
}
