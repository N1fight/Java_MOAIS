package lab1;

public class BankAccount {
    // Данные отдельного счёта и общий счётчик созданных счетов.
    private final String owner;
    private final String accountNumber;
    private double balance;

    private static int accountsCount = 0;

    // Создание счёта с нулевым начальным балансом.
    public BankAccount(String owner, String accountNumber) {
        this(owner, accountNumber, 0.0);
    }

    // Проверка данных и создание счёта с указанным балансом.
    public BankAccount(String owner, String accountNumber, double initialBalance) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Владелец счёта не указан.");
        }
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счёта не указан.");
        }
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Начальный баланс должен быть конечным неотрицательным числом.");
        }

        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        accountsCount++;
    }

    // Получение данных счёта без прямого доступа к его полям.
    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Получение общего количества созданных счетов.
    public static int getAccountsCount() {
        return accountsCount;
    }

    // Пополнение счёта после проверки суммы и возможного переполнения.
    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Ошибка: сумма должна быть конечным положительным числом.");
            return false;
        }
        if (!Double.isFinite(balance + amount)) {
            System.out.println("Ошибка: слишком большая сумма пополнения.");
            return false;
        }

        balance += amount;
        return true;
    }

    // Снятие средств возможно только при достаточном балансе.
    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Ошибка: сумма должна быть конечным положительным числом.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Ошибка: недостаточно средств на счёте.");
            return false;
        }

        balance -= amount;
        return true;
    }
}