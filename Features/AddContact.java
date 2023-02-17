package Features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import Data.Contact;
import Data.ContactList;

public class AddContact implements Actions<String[]> {

     public void showActionsInformation() {
          System.out.println(
                    "\nЧтобы добавить новый контакт, пожалуйста заполните все поля и нажмите ENTER: Введите 0, чтобы прервать добавление");
     }

     public String[] readUserInput() {
          String[] fieldTitles = { "Полное имя", "Телефон", "Почту", "Группу" };
          Collection<String> responseInput = new ArrayList<>();
          Scanner scanner = new Scanner(System.in);

          System.out.print("\nВвод информации: ");
          for (String field : fieldTitles) {
               System.out.printf("\nВведите %s: ", field);
               String res = scanner.nextLine();
               responseInput.add(res);
          }
          return responseInput.toArray(new String[3]);
     }

     @Override
     public void executeAction(String[] command) {
          Contact contact = Contact.buildContact(command[0], command[1], command[2], command[3]);

          System.out.printf("\nContactList = %s\n", ContactList.contacts.size());
          ContactList.contacts.put(contact.getId(), contact);
          System.out.printf("\nContactList = %s\n", ContactList.contacts.size());
          System.out.println("Контакт успешно добавлена!");

     }

}