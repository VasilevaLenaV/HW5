package Features;

import Data.ContactList;

public class ViewContacts implements Actions<String> {
     public void showActionsInformation() {
         System.out.println("");
         System.out.println("Список контактов: ");
     }
     @Override
     public void executeAction(String command) {
         ContactList.contacts.forEach((key, contact) -> {
             System.out.printf("\nID: " + key + ", \nПолное имя: " + contact.getName() + ", \nТелефон: "
                     + contact.getTels().toString() +"\nЭл. почта: "
                     + contact.getMails().toString() + ", \nГруппы: " + contact.getGroup().toString()
                     + "\n");
         });
 
     }

    @Override
    public String readUserInput() {
        return null;
    }
 }

