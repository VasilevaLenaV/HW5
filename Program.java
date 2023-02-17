import java.util.ArrayList;
import java.util.Collection;

import Data.ContactList;


public class Program {
    static Collection<String> currentList = new ArrayList<String>();

    public static void main(String[] args) {
        ContactList ContactList = new ContactList();
        ContactList.start();
    }
}
