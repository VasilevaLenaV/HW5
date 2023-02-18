package Features;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Data.Contact;
import Data.ContactList;

public class LoadFromFile implements Actions<String> {
     private static Logger logger = Logger.getLogger(LoadFromFile.class.getName());

     @Override
     public void showActionsInformation() {
     }

     @Override
     public String readUserInput() {
          return null;
     }

     @Override
     public void executeAction(String path) {
          try {
               Scanner scanner = new Scanner(new File(path));
               while (scanner.hasNextLine()) {
                    try {
                         String contactData = scanner.nextLine();

                         if(!contactData.isEmpty()){
                              ContactList.setContact(contactData);
                         }
                    } catch (Exception e) {
                         logger.log(Level.SEVERE, "Exception: ", e);
                    }
               }
               scanner.close();
               System.out.println("Данные из файла загружены!");
          } catch (FileNotFoundException e) {
               System.out.println("Путь или файл не существуют...");
               logger.log(Level.SEVERE, "Exception: ", e);

          } catch (Exception ex) {
               logger.log(Level.SEVERE, "Exception: ", ex);
          }

     }
}