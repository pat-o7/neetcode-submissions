class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;

        // hashset to store words
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        // use hashset as visited list by removing visited words

        // create queue with begin word in it
        // add neighbours of word to queue
        // keep track of level
        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int level = queue.size();
            result++;

            // get next word
            // mark as visited
            // check if it is endWord
            // add all neighbours of words that exist in hashset to queue
            while (level > 0) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return result;
                }

                char[] currentChars = current.toCharArray();
                for (int i = 0; i < currentChars.length; i++) {
                    char original = currentChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }
                        currentChars[i] = c;
                        String candidate = new String(currentChars);
                        if (set.contains(candidate)) {
                            set.remove(candidate);
                            queue.add(candidate);
                        }
                    }
                    currentChars[i] = original;
                }
                level--;
            }

        }
        return 0;
    }
}
