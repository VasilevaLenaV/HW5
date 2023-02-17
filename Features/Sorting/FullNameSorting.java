package Features.Sorting;

import java.util.*;

import Data.Contact;
import Data.ContactList;
import Features.Actions;

public class FullNameSorting implements Actions<String> {
     public void executeAction(String command) {
          List<Map.Entry<UUID, Contact>> entries = new ArrayList<>(ContactList.contacts.entrySet());
          Collections.sort(entries, new Comparator<Map.Entry<UUID, Contact>>() {
               public int compare(Map.Entry<UUID, Contact> firstContact, Map.Entry<UUID, Contact> secondContact) {

                    String firstContactName = firstContact.getValue().getName();
                    String secondContactName = secondContact.getValue().getName();

                    int result = firstContactName.compareTo(secondContactName);
                    return result;
               }
          });

          ContactList.contacts.clear();
          entries.forEach(entry -> {
               ContactList.contacts.put(entry.getKey(), entry.getValue());
          });

          System.out.println("Список контактов успешно отсортирован по ФИО");
     }

     @Override
     public String readUserInput() {
          return null;
     }
}