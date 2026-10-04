class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> words = new HashMap<>();
        for(String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if(!words.containsKey(key)) {
                words.put(key,new ArrayList<>());
            }
            words.get(key).add(word);
        }
        return new ArrayList<>(words.values());
    }
}