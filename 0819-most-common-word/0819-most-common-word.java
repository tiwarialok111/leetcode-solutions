class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> countMap = new HashMap<>();
        
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String[] words = normalizedStr.split("\\s+");
        
        String result = "";
        int maxCount = 0;
        
        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }
            int count = countMap.getOrDefault(word, 0) + 1;
            countMap.put(word, count);
            if (count > maxCount){ 
                maxCount = count;
                result = word;
            }
        }
        
        return result;
    }
}