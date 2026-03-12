
import java.util.*;

class week1_5{

    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String, Integer> trafficSource = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSource.put(source, trafficSource.getOrDefault(source, 0) + 1);
    }

    public void getDashboard() {

        pageViews.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(10)
                .forEach(System.out::println);
    }
}