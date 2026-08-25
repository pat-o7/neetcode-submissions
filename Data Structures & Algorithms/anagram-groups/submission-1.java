class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // result
        List<List<String>> result = new ArrayList<>();

        // buckets
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            // for each string:

            // convert to char[]
            char[] word = strs[i].toCharArray();
            // sort char[]
            Arrays.sort(word);
            // turn back to string
            String string = String.valueOf(word);

            // put in bucket
            if (map.containsKey(string)) {
                map.get(string).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.add(list);
                map.put(string, list);
            }
        }
        return result;        
    }
}
