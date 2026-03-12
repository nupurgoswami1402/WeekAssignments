import java.util.*;

class week1_2 {

    private HashMap<String, Integer> stock = new HashMap<>();
    private LinkedHashMap<Integer, String> waitingList = new LinkedHashMap<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
    }

    public synchronized String purchaseItem(String productId, int userId) {

        int current = stock.getOrDefault(productId, 0);

        if (current > 0) {
            stock.put(productId, current - 1);
            return "Success, remaining: " + (current - 1);
        } else {
            waitingList.put(userId, productId);
            return "Added to waiting list";
        }
    }

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }
}