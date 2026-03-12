import java.util.*;

class week2 {

    int tokens;
    int maxTokens;
    long lastRefill;

    week2(int max) {
        this.maxTokens = max;
        this.tokens = max;
        this.lastRefill = System.currentTimeMillis();
    }
}

class RateLimiter {

    HashMap<String, week2> clients = new HashMap<>();

    public synchronized boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new week2(1000));
        week2 bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }
}