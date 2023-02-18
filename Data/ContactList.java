
package Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import Features.Actions;
import Features.AddContact;
import Features.EditContact;
import Features.LoadFromFile;
import Features.FindContact;
import Features.RemoveContact;
import Features.SaveToFile;
import Features.ViewContacts;
import Features.Sorting.FullNameSorting;

public class ContactList {
     public static Map<UUID, Contact> contacts = new LinkedHashMap<>();
     public static boolean applicationRunning = true;

     public void start() {
          showApplicationTitle();
          while (applicationRunning) {
               showAvailableActions();
               int actionNumber = readAction();
               executeAction(actionNumber);
          }
     }

     public static void setContact(String contactData) {
          String[] contactProperties = contactData.split(";");

          if (contactProperties.length > 0) {
               String contactId = contactProperties[0];
               String contactName = contactProperties[1];
               Collection<String> contactTels = Arrays.asList(contactProperties[2]);
               Collection<String> contactMails = Arrays.asList(contactProperties[3]);
               Collection<String> contactGroups = Arrays.asList(contactProperties[4]);

               Collection<Contact> contacts = findByContact(contactName);
               if (contacts.size() > 0) {
                    contacts.forEach(c -> {
                         contactTels.forEach(k -> {
                              c.setTel(k);
                         });
                         contactMails.forEach(k -> {
                              c.setMail(k);
                         });
                         contactGroups.forEach(k -> {
                              c.setGroup(k);
                         });
                    });
               } else {
                    Contact contact = new Contact(UUID.fromString(contactId), contactName);
                    contactTels.forEach(k -> {
                         contact.setTel(k);
                    });
                    contactMails.forEach(k -> {
                         contact.setMail(k);
                    });
                    contactGroups.forEach(k -> {
                         contact.setGroup(k);
                    });
                    ContactList.contacts.put(UUID.randomUUID(), contact);
               }
          }

     }

     public static List<Contact> findByContact(String number) {
          return contacts.entrySet()
                    .stream()
                    .filter(ent -> containsContact(number, ent.getValue()))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
     }

     public static List<UUID> findByContactKey(String number) {
          return contacts.entrySet()
                    .stream()
                    .filter(ent -> containsContact(number, ent.getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
     }

     private static boolean containsContact(String findContact, Contact value) {
          return value.getName().equals(findContact) || false;
     }

     public void executeAction(int actionNumber) {
          Runnable ContactsEmpty = () -> System.out.println("В списке контактов пусто");
          String path = "contacts.txt";

          switch (actionNumber) {
               case Actions.ADD_CONTACT:
                    Actions<String[]> add = new AddContact();
                    add.showActionsInformation();
                    String[] command = add.readUserInput();
                    add.executeAction(command);
                    break;

               case Actions.FIND_CONTACT:
                    if (contacts.size() > 0) {
                         Actions<Collection<Contact>> find = new FindContact();
                         find.showActionsInformation();
                         Collection<Contact> res = find.readUserInput();
                         if (res.size() > 0)
                              find.executeAction(res);
                    } else {
                         ContactsEmpty.run();
                    }
                    break;
               case Actions.REMOVE_CONTACT:
                    if (contacts.size() > 0) {
                         Actions<Collection<UUID>> del = new RemoveContact();
                         del.showActionsInformation();
                         Collection<UUID> id = del.readUserInput();
                         if (id.size() > 0) {
                              del.executeAction(id);
                         }
                    } else {
                         ContactsEmpty.run();
                    }
                    break;

               case Actions.EDIT_CONTACT:
                    if (contacts.size() > 0) {
                         Actions<String> edit = new EditContact();
                         edit.showActionsInformation();
                         String editCommand = edit.readUserInput();
                         if (!editCommand.equals(0))
                              edit.executeAction(editCommand);
                    } else {
                         ContactsEmpty.run();
                    }
                    break;

               case Actions.DISPLAY_ALL_CONTACTS:
                    if (contacts.size() > 0) {
                         Actions<String> view = new ViewContacts();
                         view.showActionsInformation();
                         view.executeAction(null);
                    } else {
                         ContactsEmpty.run();
                    }
                    break;

               case Actions.SORT_CONTACTS_BY_FIO:
                    Actions<String> sort = new FullNameSorting();
                    sort.executeAction(null);
                    break;

               case Actions.SAVE_TO_FILE:
                    if (contacts.size() > 0) {

                         Actions<String> saveOp = new SaveToFile();
                         saveOp.executeAction(path);
                    } else {
                         ContactsEmpty.run();
                    }
                    break;

               case Actions.LOAD_FROM_FILE:
                    Actions<String> loadOp = new LoadFromFile();
                    loadOp.executeAction(path);
                    break;

               case Actions.EXIT:
                    applicationRunning = false;
                    break;
          }
     }

     public void showApplicationTitle() {
          System.out.println("Телефонный справочник");
          System.out.println("--------------------------------------------------------");
     }

     public void showAvailableActions() {
          System.out.println(
                    "\n1. Найти контакт" +
                              "\n2. Добавить контакт" +
                              "\n3. Удалить контакт" +
                              "\n4. Редактировать контакт" +
                              "\n5. Показать список контактов" +
                              "\n6. Отсортировать по ФИО" +
                              "\n7. Сохранить список в файл" +
                              "\n8. Загрузить список из файла" +
                              "\n0. Выход\n");
     }

     public int readAction() {
          List<Integer> availableActions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 0);
          int action = 0;
          Scanner userInput = new Scanner(System.in);
          while (true) {
               System.out.print("Введите № действие: ");
               action = userInput.nextInt();
               if (availableActions.contains(action)) {
                    break;
               } else {
                    System.out.println("Для выбора доступны значения, только от 0 до 9: ");
               }
          }
          return action;
     }
}