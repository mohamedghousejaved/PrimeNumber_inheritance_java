import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        Cat c = new Cat();
        c.meow();
        c.eat();

        Dog d = new Dog();
        d.bark();

        System.out.print("Enter the range (start and end): ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        System.out.println("Enter numbers (one at a time, separate by spaces): ");
        scanner.nextLine(); // Consume newline
        String[] numbersInput = scanner.nextLine().split(" ");

        for (String numberStr : numbersInput) {
            int number = Integer.parseInt(numberStr);
            d.appendToList(number);
            c.appendToList(number);
        }

        d.printPrimeNumbers();
        c.reverseAndPrintList();

        scanner.close();
    }
}

class Animal {
    void eat() {
        System.out.println("eating...");
    }

    // Method to check if a number is prime
    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Dog extends Animal {
    private List<Integer> numberList = new ArrayList<>();

    // Method to add numbers to the list
    void appendToList(int number) {
        numberList.add(number);
    }

    // Method to filter and print prime numbers from the list
    void printPrimeNumbers() {
        System.out.println("Prime numbers in the list:");
        for (int number : numberList) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
    }

    void bark() {
        System.out.println("barking...");
    }
}

class Cat extends Animal {
    private List<Integer> numberList = new ArrayList<>();

    // Method to add numbers to the list
    void appendToList(int number) {
        numberList.add(number);
    }

    // Method to reverse and print the list
    void reverseAndPrintList() {
        System.out.println("Reversed list:");
        for (int i = numberList.size() - 1; i >= 0; i--) {
            System.out.println(numberList.get(i));
        }
    }

    void meow() {
        System.out.println("meowing...");
    }
}
