import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("Введите размер списка: ");
        String n = scanner.nextLine();
        System.out.print("Введите верхнюю границу для значений: ");
        String m = scanner.nextLine();

        logger.log("Создаём и наполняем список");
        List<Integer> source = getRandomNumbers(Integer.parseInt(n), Integer.parseInt(m));
        System.out.print("Вот случайный список: ");
        printList(source);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        String f = scanner.nextLine();

        Filter filter = new Filter(Integer.parseInt(f));
        List<Integer> result = filter.filterOut(source);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        printList(result);
        logger.log("Завершаем программу");
    }

    public static List<Integer> getRandomNumbers(int size, int upperBound) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(upperBound));
        }
        return result;
    }

    public static void printList(List<Integer> list) {
        String joinedList = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(joinedList);
    }
}
