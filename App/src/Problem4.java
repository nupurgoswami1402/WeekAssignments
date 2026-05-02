import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ":" + returnRate;
    }
}

public class Problem4 {

    static void mergeSort(List<Asset> list) {
        list.sort(Comparator.comparingDouble(a -> a.returnRate));
        System.out.println("Merge Sort: " + list);
    }

    static void quickSort(List<Asset> list) {
        list.sort((a, b) -> {
            if (b.returnRate != a.returnRate)
                return Double.compare(b.returnRate, a.returnRate);
            return Double.compare(a.volatility, b.volatility);
        });

        System.out.println("Quick Sort: " + list);
    }

    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();
        assets.add(new Asset("AAPL", 12, 0.2));
        assets.add(new Asset("TSLA", 8, 0.3));
        assets.add(new Asset("GOOG", 15, 0.1));

        mergeSort(new ArrayList<>(assets));
        quickSort(assets);
    }
}
