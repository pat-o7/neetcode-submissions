class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // create hashmap<id, indices[]>
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        // list of keys
        ArrayList<String> keys = new ArrayList<>();

        // iterate through strs
        for (int i = 0; i < strs.length; i++) {
        // each string
            // convert to char array
            char[] characters = strs[i].toCharArray();
            // sort
            Arrays.sort(characters);
            // convert back to string
            String sorted = new String(characters);

            // check if it exists in map
            if (map.containsKey(sorted)) {
                ArrayList<Integer> indices = map.get(sorted);
                indices.add(i);
                map.put(sorted, indices);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(sorted, indices);
                keys.add(sorted);
            }
        }

        List<List<String>> result = new ArrayList<>();

            // iterate through keys of hashmap
            for (String key : keys) {
                // for each key value in hashmap
                ArrayList<String> anagrams = new ArrayList<>();                
                for (int index : map.get(key)) {
                    anagrams.add(strs[index]);
                }
                result.add(anagrams);
            }

        // return list of list of strings
        return result;        
    }
}
