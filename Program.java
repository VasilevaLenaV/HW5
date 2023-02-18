import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import Data.ContactList;

public class Program {
    static Logger logger;
    static {
        try (InputStream input = Program.class.getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(input);
            logger = Logger.getLogger(Program.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static Collection<String> currentList = new ArrayList<String>();

    public static void main(String[] args) {
        logger.info("start");
        ContactList ContactList = new ContactList();
        ContactList.start();
        logger.info("end");
    }

}