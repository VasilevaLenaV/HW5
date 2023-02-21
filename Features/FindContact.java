package Features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Data.Contact;
import Data.ContactList;

public class FindContact implements Actions<Collection<Contact>> {
    private static Logger logger = Logger.getLogger(FindContact.class.getName());

    @Override
    public void showActionsInformation() {
        System.out.println("\nДля поиска контакта введите его данные\nВведите 0 для возрата в Меню\n");
    }

    @Override
    public Collection<Contact> readUserInput() {
        while (true) {
            try {
                System.out.print("\nВведите данные контакта для поиска:");
                Scanner in = new Scanner(System.in);
                String userInput = in.nextLine();
                if (userInput != "") {
                    Collection<Contact> res = ContactList.findByContact(userInput);
                    if (res.isEmpty()) {
                        System.out.println("Контакт с такими параметрами не найден, попробуйте снова: ");
                    }
                    return res;
                }
                return new ArrayList<>();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception: ", e);
            }
        }
    }

    @Override
    public void executeAction(Collection<Contact> command) {
        try {
            if (command.size() > 0) {
                command.forEach(k -> {
                    System.out.printf("\nID: " + k.getId() + ", \nПолное имя: " + k.getName() + ", \nТелефон: "
                            + k.getTels().toString() + "\nЭл. почта: "
                            + k.getMails().toString() + ", \nГруппы: " + k.getGroups().getValue().toString()
                            + "\n");
                });
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
    }
}
