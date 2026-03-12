import java.util.*;

class week2_1 {

    HashMap<String, Integer> frequency = new HashMap<>();

    public void addQuery(String query) {
        frequency.put(query, frequency.getOrDefault(query, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> result = new ArrayList<>();

        for (String q : frequency.keySet()) {
            if (q.startsWith(prefix)) {
                result.add(q);
            }
        }

        result.sort((a, b) -> frequency.get(b) - frequency.get(a));

        return result.subList(0, Math.min(10, result.size()));
    }
}