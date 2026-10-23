class Solution {
    public List<List<String>> groupAnagrams(String[] words) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
                if(!map.containsKey(key)) {
                    map.put(key , new ArrayList<>());
                }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
