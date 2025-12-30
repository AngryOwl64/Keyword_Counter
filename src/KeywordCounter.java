import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class KeywordCounter {
    private HashMap<String, Integer> keywordMap = new HashMap<>();
    public KeywordCounter(String[] keywords) {
        for (String s : keywords) {
            keywordMap.put(s, 0);
        }
    }


    public void countKeywords(String input) { // Counts how often each keyword appears in the input text
        String trimmed = input.trim();
        String lowerCase = trimmed.toLowerCase(); // normalize case
        String cleaned = lowerCase.replaceAll("[^a-zA-Z0-9\\s]", " "); // remove punctuation
        String[] words = cleaned.split("\\s+"); // split into words
        for (String s : words) {
            if (keywordMap.containsKey(s)) {
                keywordMap.replace(s, keywordMap.get(s) + 1);
            }
        }
    }

    public void printCounts() { // Prints all keyword counts
        int maxLength = 0;
        for (String s : keywordMap.keySet()) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        int columnWidth = maxLength + 3;
        ArrayList<Map.Entry<String, Integer>> entrySet = new ArrayList<>(keywordMap.entrySet());
        entrySet.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); //Sort entries by value in descending order


        String spaces = "";

        System.out.println("=== Keyword Analysis ===");
        for (Map.Entry<String, Integer> s : entrySet) {
            spaces = "";
            int spacesNeeded = columnWidth - s.getKey().length();
            for (int i = 0; i < spacesNeeded; i++) {
                spaces = spaces + " ";
            }
            System.out.println(s.getKey() + spaces + s.getValue());
        }
    }

    public void resetCounter() {
        for (String s : keywordMap.keySet()) {
            keywordMap.replace(s, 0);
        }
    }
}
