package Features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import Data.Contact;
import Data.ContactList;

public class FindContact implements Actions<Collection<Contact>> {
    public void showActionsInformation() {
        System.out.println("\nДля поиска контакта введите его данные\nВведите 0 для возрата в Меню\n");
    }

    @Override
    public Collection<Contact> readUserInput() {
        while (true) {
            System.out.print("\nВведите данные контакта для поиска:");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                if (userInput != "") {
                    Collection<Contact> res = ContactList.findByContact(userInput);
                    if (res.isEmpty()) {
                        System.out.println("Контакт с такими параметрами не найден, попробуйте снова: ");
                    }
                    return res;
                }
                return new ArrayList<>();
            } catch (Exception err) {
                System.out.println("Введите данные контакта для поиска или 0 для возврата в Меню");
            }
        }
    }

    @Override
    public void executeAction(Collection<Contact> command) {
        if (command.size() > 0) {
            command.forEach(k -> {
                System.out.printf("\nID: " + k.getId() + ", \nПолное имя: " + k.getName() + ", \nТелефон: "
                        + k.getTels().toString() + "\nЭл. почта: "
                        + k.getMails().toString() + ", \nГруппы: " + k.getGroup().toString()
                        + "\n");
            });
        }
    }
}
