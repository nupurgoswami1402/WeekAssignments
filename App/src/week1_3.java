import java.util.*;

class week1_3 {

    String ip;
    long expiry;

    week1_3(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

class DNSCache {

    HashMap<String, week1_3> cache = new HashMap<>();
    int hits = 0;
    int misses = 0;

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {

            week1_3 entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiry) {
                hits++;
                return entry.ip;
            }

            cache.remove(domain);
        }

        misses++;
        String ip = queryDNS(domain);
        cache.put(domain, new week1_3(ip, 300));

        return ip;
    }

    private String queryDNS(String domain) {
        return "172.217.14." + new Random().nextInt(255);
    }

    public void getStats() {
        int total = hits + misses;
        System.out.println("Hit Rate: " + (hits * 100.0 / total) + "%");
    }
}