import java.util.*;

class week1_4 {

    HashMap<String, Set<String>> index = new HashMap<>();

    public List<String> getNGrams(String text, int n) {

        String[] words = text.split(" ");
        List<String> grams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(words[i + j]).append(" ");
            }

            grams.add(sb.toString().trim());
        }

        return grams;
    }

    public void indexDocument(String docId, String text) {

        List<String> grams = getNGrams(text, 5);

        for (String g : grams) {
            index.putIfAbsent(g, new HashSet<>());
            index.get(g).add(docId);
        }
    }

    public int checkSimilarity(String text) {

        List<String> grams = getNGrams(text, 5);
        int matches = 0;

        for (String g : grams) {
            if (index.containsKey(g)) {
                matches++;
            }
        }

        return matches;
    }
}