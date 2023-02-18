package Features;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import Data.Contact;
import Data.ContactList;

public class SaveToFile implements Actions<String> {
    private static Logger logger = Logger.getLogger(SaveToFile.class.getName());

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
            PrintWriter pw = new PrintWriter(new FileOutputStream(path));

            List<Contact> lines = ContactList.contacts.entrySet().stream().map(entry -> entry.getValue())
                    .collect(Collectors.toList());

            lines.forEach(k -> {
                pw.printf("\n%s;%s;%s;%s;%s", k.getId().toString(), k.getName(), k.getTels().toString().replaceAll("\\[|\\]", ""),
                        k.getMails().toString().replaceAll("\\[|\\]", ""), k.getGroup().toString().replaceAll("\\[|\\]", ""));
            });
            pw.close();
            System.out.println("Список контактов успешно сохранен: " + path);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "FileNotFoundException: ", e);
            System.out.println("Путь или файл не существуют...");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception: ", ex);
        }
    }
}