package Features;

import java.util.logging.Level;
import java.util.logging.Logger;

import Data.ContactList;

public class ViewContacts implements Actions<String> {
    private static Logger logger = Logger.getLogger(ViewContacts.class.getName());

    @Override
    public void showActionsInformation() {
        System.out.println("\nСписок контактов: ");
    }

    @Override
    public void executeAction(String command) {
        try {
            if(ContactList.contacts.size()>0){
                ContactList.contacts.forEach((key, contact) -> {
                    System.out.printf("\nID: " + key + ", \nПолное имя: " + contact.getName() + ", \nТелефон: "
                            + contact.getTels().toString() + "\nЭл. почта: "
                            + contact.getMails().toString() + ", \nГруппы: " + contact.getGroup().toString()
                            + "\n");
                });
            } 
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
    }

    @Override
    public String readUserInput() {
        return null;
    }
}
