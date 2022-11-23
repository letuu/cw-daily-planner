package pro.sky.java.ds_3_0.task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {

    // 2 Создать метод, который преобразует массив объектов User (c полями name, age, phone)
    // в карту Номер телефона -> Имя пользователя
    private static User[] users = new User[3];

    public static void main(String[] args) {

        User user1 = new User("Иван", 35, "8-920-000-0000");
        User user2 = new User("Сергей", 37, "8-930-000-0000");
        User user3 = new User("Дмитрий", 39, "8-950-000-0000");

        users[0] = user1;
        users[1] = user2;
        users[2] = user3;

        System.out.println(Arrays.toString(users));
        System.out.println(List.of(arrayToMap(users)));
    }

    public static Map<String, String> arrayToMap(User[] users) {

        Map<String, String> mapPhoneBook = new HashMap<>();
        for (int i = 0; i < users.length; i++) {
            mapPhoneBook.put(users[i].getPhone(), users[i].getName());
        }
        return mapPhoneBook;
    }
}
