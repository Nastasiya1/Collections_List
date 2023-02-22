import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> products = new ArrayList<>();

    public static void showProducts() {
        System.out.println("Список покупок:");
        for (int i = 0; i < products.size(); i++) {
            System.out.print(i + 1 + ". " + products.get(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        operations.add("добавить");
        operations.add("показать");
        operations.add("удалить");


        while (true) {
            System.out.println("Выберите операцию");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("Какую покупку хотите добавить?");
                    Scanner scanner1 = new Scanner(System.in);
                    products.add(scanner1.nextLine());
                    System.out.println("Итого в списке покупок " + products.size());
                }
                case 2, 3 -> showProducts();
            }
            if (input == 3) {
                System.out.println("Какую покупку хотите удалить? Введите номер или название");
                Scanner scanner2 = new Scanner(System.in);
                String input1 = scanner2.nextLine();
                try {
                    int input2 = Integer.parseInt(input1);
                    System.out.println("Покупка " + products.get(input2 - 1) + " удалена, список покупок:");
                    products.remove(input2 - 1);

                } catch (RuntimeException e) {
                    products.remove(input1);
                    System.out.println("Покупка " + input1 + " удалена, список покупок:");
                } finally {
                    showProducts();
                }
            }
        }
    }
}