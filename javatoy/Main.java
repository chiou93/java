package javatoy;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        toyShop.addToy(new Toy(1, "Doll", 10, 10));
        toyShop.addToy(new Toy(2, "Robot", 5, 30));
        toyShop.addToy(new Toy(3, "Car", 20, 20));
        toyShop.addToy(new Toy(4, "Puzzle", 15, 40));
        toyShop.addToy(new Toy(5, "Bicycle", 3, 1));

        toyShop.updateToyWeight(1, 20);
        toyShop.updateToyWeight(3, 10);

        Toy prizeToy = toyShop.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Congratulations! You won a " + prizeToy.getName());
            toyShop.writePrizeToyToFile(prizeToy, "prize.txt");
        } else {
            System.out.println("Sorry, no prize for you.");
        }
    }
}