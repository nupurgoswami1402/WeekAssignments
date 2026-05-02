import java.util.*;

class Client {
    String name;
    int riskScore;
    double balance;

    Client(String name, int riskScore, double balance) {
        this.name = name;
        this.riskScore = riskScore;
        this.balance = balance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Problem2 {

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Bubble Asc: " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                  (arr[j].riskScore < key.riskScore ||
                  (arr[j].riskScore == key.riskScore &&
                   arr[j].balance < key.balance))) {

                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Insertion Desc: " + Arrays.toString(arr));
    }

    static void topClients(Client[] arr, int k) {
        System.out.println("Top " + k + " Risks:");
        for (int i = 0; i < k && i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Client[] clients = {
            new Client("C", 80, 5000),
            new Client("A", 20, 2000),
            new Client("B", 50, 3000)
        };

        bubbleSort(clients.clone());
        insertionSort(clients);
        topClients(clients, 3);
    }
}
