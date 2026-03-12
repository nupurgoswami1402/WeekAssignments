class week2_3 {

    String[] table;
    int size;

    week2_3(int size) {
        this.size = size;
        table = new String[size];
    }

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % size;
    }

    public int parkVehicle(String plate) {

        int index = hash(plate);

        while (table[index] != null) {
            index = (index + 1) % size;
        }

        table[index] = plate;
        return index;
    }

    public void exitVehicle(String plate) {

        int index = hash(plate);

        while (table[index] != null) {

            if (table[index].equals(plate)) {
                table[index] = null;
                return;
            }

            index = (index + 1) % size;
        }
    }
}