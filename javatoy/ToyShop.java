package javatoy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy getPrizeToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double randomValue = new Random().nextDouble() * totalWeight;
        for (Toy toy : toys) {
            randomValue -= toy.getWeight();
            if (randomValue <= 0) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    return toy;
                } else {
                    return null;
                }
            }
        }

        return null;
    }

    public void writePrizeToyToFile(Toy toy, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Prize Toy: " + toy.getName());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing prize toy to file: " + e.getMessage());
        }
    }
}