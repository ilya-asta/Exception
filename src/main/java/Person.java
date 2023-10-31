import java.util.Scanner;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;
    public static Person getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в порядке, разделенные пробелом: фамилия имя отчество дата_рождения номер_телефона пол");
        String userInput = scanner.nextLine();

        String[] inputArray = userInput.split(" ");

        if (inputArray.length != 6) {
            System.out.println("Ошибка: введено неправильное количество данных. Должно быть 6 элементов.");
            return null;
        }

        try {
            String lastName = inputArray[0];
            String firstName = inputArray[1];
            String middleName = inputArray[2];
            String birthDate = inputArray[3];

            // Проверка формата даты
            if (!isValidDateFormat(birthDate)) {
                System.out.println("Ошибка: неверный формат даты рождения. Используйте dd.mm.yyyy.");
                return null;
            }

            long phoneNumber = Long.parseLong(inputArray[4]);

            // Проверка положительности номера телефона
            if (phoneNumber <= 0) {
                System.out.println("Ошибка: номер телефона должен быть положительным числом.");
                return null;
            }

            char gender = inputArray[5].charAt(0);

            // Проверка корректности значения пола
            if (gender != 'ж' && gender != 'м') {
                System.out.println("Ошибка: пол должен быть 'ж' или 'м'.");
                return null;
            }

            return new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Ошибка при разборе данных. Проверьте формат введенных данных.");
            return null;
        }
    }
    // Проверка формата даты (dd.mm.yyyy)
    private static boolean isValidDateFormat(String date) {
        return date.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    public Person(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastName + "\n" +
                "Имя: " + firstName + "\n" +
                "Отчество: " + middleName + "\n" +
                "Дата рождения: " + birthDate + "\n" +
                "Номер телефона: " + phoneNumber + "\n" +
                "Пол: " + gender;
    }
}
