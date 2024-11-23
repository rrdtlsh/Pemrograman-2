package soal1;

import java.util.LinkedList;

public class Dadu {
    private int input; 
    private int total; 

    public void setInput(int input) {
        if (input <= 0) { 
            System.out.println("Jumlah dadu harus lebih dari 0.");
            return;
        }
        this.input = input;
    }

    public void acakNilai() {
        if (input <= 0) {
            System.out.println("Jumlah dadu belum diatur atau tidak valid.");
            return;
        }

        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            ll.add(i);
        }

        total = 0;
        for (int i = 1; i <= input; i++) {
            if (ll.isEmpty()) {
                System.out.println("Dadu ke-" + i + " tidak memiliki nilai.");
            } else {
                int randomIndex = (int) (Math.random() * ll.size());
                int randomValue = ll.remove(randomIndex);
                System.out.println("Dadu ke-" + i + " bernilai " + randomValue);
                total += randomValue;
            }
        }
        System.out.println("Total nilai dadu keseluruhan: " + total);
    }
}