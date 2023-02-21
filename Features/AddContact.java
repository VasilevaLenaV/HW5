package Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Data.Contact;
import Data.ContactList;

public class AddContact implements Actions<String[]> {
     private static Logger logger = Logger.getLogger(AddContact.class.getName());

     @Override
     public void showActionsInformation() {
          System.out.println("\nЧтобы добавить новый контакт, пожалуйста заполните все поля и нажмите ENTER: Введите 0, чтобы прервать добавление");
     }
     @Override
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
          logger.info(Arrays.toString(responseInput.toArray()));
          return responseInput.toArray(new String[3]);
     }

     @Override
     public void executeAction(String[] command) {
          try {
               Contact contact = new Contact(command[0], command[1], command[2], command[3]);
               ContactList.contacts.put(contact.getId(), contact);
               logger.info(String.format("add contact %s", contact.getId()));
         } catch (Exception ex) {
               logger.log(Level.SEVERE, "Exception: ", ex);
          }

          System.out.println("Контакт успешно добавлен!");
     }

}