package lab1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание массива счетов с использованием двух конструкторов.
        BankAccount[] accounts = {
            new BankAccount("Константин Тулинов", "1001", 1500.00),
            new BankAccount("Пётр Петров", "1002", 850.00),
            new BankAccount("Ира Иринова", "1003")
        };

        // До выбора пользователем текущий счёт отсутствует.
        BankAccount selected = null;
        boolean running = true;

        // Scanner автоматически закрывается при завершении работы.
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                // Главное меню повторяется после выполнения команды.
                System.out.println("\n=== Банк ===");
                System.out.println();
                System.out.println("----------------------");
                System.out.println();
                System.out.println("1. Список счетов");
                System.out.println("2. Выбрать счёт");
                System.out.println("3. Информация о выбранном счёте");
                System.out.println("4. Пополнить счёт");
                System.out.println("5. Снять средства");
                System.out.println("6. Количество созданных счетов");
                System.out.println();
                System.out.println("----------------------");
                System.out.println();
                System.out.println("0. Выход");
                System.out.print("Выберите пункт: ");

                if (!scanner.hasNextLine()) {
                    break;
                }

                String command = scanner.nextLine().trim();

                // Выбор действия по введённой команде.
                switch (command) {
                    case "1" -> printAccounts(accounts);

                    case "2" -> {
                        // Проверка номера пункта и сохранение выбранного счёта.
                        printAccounts(accounts);
                        System.out.print("Введите номер пункта списка: ");

                        if (!scanner.hasNextLine()) {
                            running = false;
                            break;
                        }

                        try {
                            int number = Integer.parseInt(scanner.nextLine().trim());

                            if (number >= 1 && number <= accounts.length) {
                                selected = accounts[number - 1];
                                System.out.println(
                                        "Выбран счёт № " + selected.getAccountNumber() + ".");
                            } else {
                                System.out.println("Ошибка: такого пункта в списке нет.");
                            }
                        } catch (NumberFormatException error) {
                            System.out.println("Ошибка: введите целый номер пункта списка.");
                        }
                    }

                    case "3" -> {
                        // Информация доступна после выбора счёта.
                        if (selected == null) {
                            System.out.println("Сначала выберите счёт (пункт 2).");
                        } else {
                            System.out.println("Владелец: " + selected.getOwner());
                            System.out.println("Номер счёта: " + selected.getAccountNumber());
                            printBalance(selected);
                        }
                    }

                    case "4", "5" -> {
                        // Пополнение и снятие используют общий ввод суммы.
                        if (selected == null) {
                            System.out.println("Сначала выберите счёт (пункт 2).");
                            break;
                        }

                        System.out.print("Введите сумму (например, 100.50 или 100,50): ");

                        if (!scanner.hasNextLine()) {
                            running = false;
                            break;
                        }

                        try {
                            // Замена запятой позволяет использовать оба разделителя.
                            String amountText = scanner.nextLine().trim().replace(',', '.');
                            double amount = Double.parseDouble(amountText);

                            boolean success = command.equals("4")
                                    ? selected.deposit(amount)
                                    : selected.withdraw(amount);

                            if (success) {
                                System.out.println("Операция выполнена.");
                                printBalance(selected);
                            }
                        } catch (NumberFormatException error) {
                            System.out.println("Ошибка: введите сумму числом.");
                        }
                    }
                    case "6" -> // Статический метод вызывается через имя класса.
                        System.out.println(
                                "Создано счетов: " + BankAccount.getAccountsCount());

                    case "0" -> running = false;

                    default -> System.out.println("Ошибка: такого пункта меню нет.");
                }
            }
        }

        System.out.println("Работа программы завершена.");
    }

    // Вывод списка с нумерацией, начинающейся с единицы.
    private static void printAccounts(BankAccount[] accounts) {
        System.out.println("Список счетов:");

        for (int i = 0; i < accounts.length; i++) {
            System.out.println((i + 1) + ". № " + accounts[i].getAccountNumber()
                    + " - " + accounts[i].getOwner());
        }
    }

    // Вывод баланса с двумя знаками после десятичной точки.
    private static void printBalance(BankAccount account) {
        System.out.printf(Locale.ROOT, "Баланс: %.2f%n", account.getBalance());
    }
}