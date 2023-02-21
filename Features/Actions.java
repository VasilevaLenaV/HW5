package Features;

public interface Actions<T> {
     public static final int FIND_CONTACT = 1;
     public static final int ADD_CONTACT = 2;
     public static final int REMOVE_CONTACT = 3;
     public static final int EDIT_CONTACT = 4;
     public static final int DISPLAY_ALL_CONTACTS = 5;
     public static final int SORT_CONTACTS_BY_FIO = 6;
     public static final int SAVE_TO_FILE = 7;
     public static final int LOAD_FROM_FILE = 8;
     public static final int EXIT = 0;

     public default void showActionsInformation(){
     };

     public default T readUserInput( ){
          return null;
     }

     public void executeAction(T command);
}
