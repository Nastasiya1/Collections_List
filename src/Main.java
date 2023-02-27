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

        while (true) {
            System.out.println("Выберите операцию");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("Какую покупку хотите добавить?");
                    addProduct();
                    System.out.println("Итого в списке покупок " + products.size());
                }
                case 2 -> showProducts();
                case 3 -> {
                    showProducts();
                    System.out.println("Какую покупку хотите удалить? Введите номер или название");
                    deleteProduct();
                }
                case 4 -> {
                    System.out.println("Введите текст для поиска:");
                    searchProduct();
                }
            }
        }
    }

    private static void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String queryLower = input.toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < products.size(); i++) {
            String itemLower = products.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println(i + 1 + ". " + products.get(i));
            }
        }
    }

    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int input2 = Integer.parseInt(input);
            System.out.println("Покупка " + products.get(input2 - 1) + " удалена, список покупок:");
            products.remove(input2 - 1);

        } catch (RuntimeException e) {
            products.remove(input);
            System.out.println("Покупка " + input + " удалена, список покупок:");
        } finally {
            showProducts();
        }
    }

    private static void addProduct() {
        Scanner scanner1 = new Scanner(System.in);
        products.add(scanner1.nextLine());
    }
}