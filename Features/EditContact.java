package Features;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Data.Contact;
import Data.ContactList;

public class EditContact implements Actions<String> {
     private static Logger logger = Logger.getLogger(EditContact.class.getName());

     @Override
     public void showActionsInformation() {
          System.out.println(
                    "\nРедактирование контакта, Введите новые данные контакта, после поиска поочередно заполните значения параметров, используйте ввод что бы перейти к следующему.");
          System.out.println(
                    "Если обновление параметра не требуется, укажите символ (-)\nДля возврата в меню введите 0\n");
     }

     @Override
     public String readUserInput() {
          Scanner in = new Scanner(System.in);

          while (true) {
               try {
                    System.out.println("\nВведите контакт для редактирования:\n");
                    String userInput = in.nextLine();

                    if (!userInput.equals("0")) {
                         if (ContactList.findByContact(userInput).isEmpty()) {
                              System.out.println("\nВведите контакт для редактирования:\n");
                         } else {
                              return userInput;
                         }
                    } else {
                         return userInput;
                    }
               } catch (Exception e) {
                    logger.log(Level.SEVERE, "Exception: ", e);
               }
          }
     }

     @Override
     public void executeAction(String command) {
          List<Contact> Contacts = ContactList.findByContact(command);

          Scanner scanner = new Scanner(System.in);

          Contacts.forEach(t -> {
               String userInput = "";
               try {
                    System.out.printf("\nВведите Полное имя: ", t.getName());
                    userInput = scanner.nextLine();

                    if (!userInput.equals("-") && !userInput.isEmpty() && !userInput.equals(t.getName())) {
                         t.setName(userInput);
                    }
                    System.out.printf("\nВведите телефонный номер, который нужно заменить: %s\n",
                              t.getTels().getValue().toString());
                    userInput = scanner.nextLine();

                    if (!userInput.isEmpty() || !userInput.equals("-")) {
                         System.out.printf("\nВведите телефонный номер, который нужно добавить: ");
                         String newTel = scanner.nextLine();
                         t.getTels().replaceValue(userInput, newTel);
                    }
                    System.out.printf("\nВведите эл. почту, который нужно заменить: %s\n", t.getMails().getValue().toString());
                    userInput = scanner.nextLine();

                    if (!userInput.isEmpty() || !userInput.equals("-")) {
                         System.out.printf("\nВведите эл. почту, который нужно добавить: ");
                         String newEmail = scanner.nextLine();
                         t.getMails().replaceValue(userInput, newEmail);
                    }
                    System.out.printf("\nВведите группу, который нужно заменить: %s\n", t.getGroups().getValue().toString());
                    userInput = scanner.nextLine();

                    if (!userInput.isEmpty() || !userInput.equals("-")) {
                         System.out.printf("\nВведите группу, который нужно добавить: ");
                         String newGroup = scanner.nextLine();
                         t.getGroups().replaceValue(userInput, newGroup);
                    }
               } catch (Exception e) {
                    logger.log(Level.SEVERE, "Exception: ", e);
               }
          });

          System.out.println("Обновление  успешно завершено");
     }
}