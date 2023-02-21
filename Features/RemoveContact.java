package Features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import Data.ContactList;

public class RemoveContact implements Actions<Collection<UUID>> {
     private static Logger logger = Logger.getLogger(RemoveContact.class.getName());

     @Override
     public void showActionsInformation() {
          System.out.printf(
                    "\nДля удаление контакта ,введите  его данные и нажмите Ввод\n\nДля возрата к меню нажмите 0\n");
     }

     @Override
     public Collection<UUID> readUserInput() {
          Scanner in = new Scanner(System.in);
          
          while (true) {
               try {
                    System.out.println("");
                    System.out.print("Введите данные контакта: ");

                    String userInput = in.nextLine();

                    if (!userInput.isEmpty()) {
                         if (userInput == "0")
                              return new ArrayList<>();

                         Collection<UUID> res = ContactList.findByContactKey(userInput);

                         if (res.size() > 0) {
                              return res;
                         }

                         System.out.println("В списке контактов такой отстутствует");
                    } else {
                         System.out.println("Введите данные контакта или 0 для возрата к меню");
                    }
               } catch (Exception e) {
                    logger.log(Level.SEVERE, "Exception: ", e);
               }

          }

     }

     @Override
     public void executeAction(Collection<UUID> command) {
          try {
               if (command.size() > 0) {
                    command.forEach(k -> {
                         ContactList.contacts.remove(k);
                    });
                    System.out.println("Контакты: " + command + ", были успешно удалены");
               }
          } catch (Exception e) {
               logger.log(Level.SEVERE, "Exception: ", e);
          }
          
     }

}