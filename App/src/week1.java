import java.util.*;

class week1 {

    private HashMap<String, Integer> usernameMap = new HashMap<>();
    private HashMap<String, Integer> attemptFrequency = new HashMap<>();
    private int userIdCounter = 1;

    public boolean checkAvailability(String username) {
        attemptFrequency.put(username,
                attemptFrequency.getOrDefault(username, 0) + 1);

        return !usernameMap.containsKey(username);
    }

    public void registerUser(String username) {
        if (checkAvailability(username)) {
            usernameMap.put(username, userIdCounter++);
        } else {
            System.out.println("Username already taken");
        }
    }

    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String candidate = username + i;
            if (!usernameMap.containsKey(candidate)) {
                suggestions.add(candidate);
            }
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    public String getMostAttempted() {
        String result = "";
        int max = 0;

        for (String key : attemptFrequency.keySet()) {
            int freq = attemptFrequency.get(key);
            if (freq > max) {
                max = freq;
                result = key;
            }
        }

        return result + " (" + max + " attempts)";
    }
}