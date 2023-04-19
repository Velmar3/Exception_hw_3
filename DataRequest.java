import java.io.FileWriter;
import java.util.Scanner;

public class DataRequest {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthday;
    private long numberPhone;
    private char gender;
    private Scanner scan = new Scanner(System.in);

    // Методы для присваивания значений полям
    private void EnterFirstName() {
        System.out.print("Enter Firstname: ");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterLastName() {
        System.out.print("Enter LastName: ");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterPatronymic() {
        System.out.print("Enter Patronymic: ");
        patronymic = scan.nextLine();
        if (patronymic.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterBirthday() {
        System.out.print("Enter Birthday: ");
        birthday = scan.nextLine();
        if (birthday.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.print("Enter Number Phone: ");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.print("Enter Gender (f, m): ");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов \nпопробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");
        }
    }

    // Метод для вывода в консоль получившихля значений
    private void OutPutData() {
        System.out.println("\nFirstName \t- \t" + firstName + "\n" +
                "LastName \t- \t" + lastName + "\n" +
                "Patronymic \t- \t" + patronymic + "\n" +
                "Birthday \t- \t" + birthday + "\n" +
                "NumberPhone \t- \t" + numberPhone + "\n" +
                "Gender   \t- \t" + gender);
    }

    // Метод для соединения всех методов в один
    private void DataEnter() {
        EnterFirstName();
        EnterLastName();
        EnterPatronymic();
        EnterBirthday();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    // Метод для сохранения данных в файл
    public void SaveDataEnter() {

        DataEnter();
        String file = "file/" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " +
                    "<" + lastName + "> " +
                    "<" + patronymic + "> " +
                    "<" + birthday + "> " +
                    "<" + numberPhone + "> " +
                    "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    // Геттеры для полей

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }
}