package JAVA;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class J8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        
        while (true) {
            System.out.println("Введите фамилию и через пробел номер телефона. Для выхода добавьте пустую строку");
            String input = scanner.nextLine();

            if (input.isEmpty()) 
            break;
            
            String[] parts = input.split(" ");
            String famil = parts[0];
            String num1 = parts[1];

            if (phoneBook.containsKey(famil)) {
                ArrayList<String> num2 = phoneBook.get(famil);
                num2.add(num1);
            } 
            else {
                ArrayList<String> num2 = new ArrayList<>();
                num2.add(num1);
                phoneBook.put(famil, num2);
            }
        }

        ArrayList<String> familPhone = new ArrayList<>();
        for (String famil : phoneBook.keySet()) {
            ArrayList<String> num2 = phoneBook.get(famil);
            familPhone.add(famil + ": " + String.join(", ", num2));
        }

        Collections.sort(familPhone);

        System.out.println("Телефонный справочник:");
        for (String entry : familPhone)
            System.out.println(entry);
    }
}
 