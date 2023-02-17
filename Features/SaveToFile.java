package Features;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Data.ContactList;

public class SaveToFile implements Actions<String> {
     public void showActionsInformation() {
         System.out.println("\nУкажите путь для файла или введите \"-\" -путь по умолчанию:\nВведите 0 для возврата к меню");
     }
     
     @Override
     public String readUserInput() {
          Scanner scan = new Scanner(System.in);

          while (true) {
             System.out.print("\nПуть:");
             return scan.nextLine();
         }
     }
     
     @Override
     public void executeAction(String path) {
         try {
             PrintWriter pw = new PrintWriter(new FileOutputStream(path));
 
             List<String> lines = ContactList.contacts.entrySet().stream().map(entry -> entry.getValue().toString()).collect(Collectors.toList());
 
             lines.forEach((line) -> {
                 pw.println(line);
             });
             pw.close();
             System.out.println("Список контактов успешно сохранен: " + path);
         } catch (FileNotFoundException e) {
             System.out.println("Путь или файл не существуют...");
         }
 
     }
 }