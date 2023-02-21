package Data;

import java.util.UUID;

public class Contact  {
     private UUID id;
     private String name;
     private ObjectData<String> tels = new ObjectData<String>();
     ObjectData<String> mails = new ObjectData<String>();
     ObjectData<String> groups = new ObjectData<String>();
     private Melody melody;

     public Contact() {
     }
    
     public void setTels(ObjectData<String> tels) {
          this.tels = tels;
     }
     public Contact(String name) {
          this.name = name;
     }
     public Contact(UUID id, String name) {
          this.id = id;
          this.name = name;
     }

     public Contact(String name, String tel) {
          this.id = UUID.randomUUID();
          this.name = name;
          tels.setValue(tel);
     }

     public Contact(String name, String tel, String mail,String group) {
          this.id = UUID.randomUUID();
          this.name =name;
          tels.setValue(tel);
          mails.setValue(mail);
          groups.setValue(group);
     }

     public UUID getId() {
          return id;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getName() {
          return name;
     }

     public void setMelody(Melody melody) {
          this.melody = melody;
     }

     public Melody getMelody() {
          return melody;
     }

     public ObjectData<String> getTels() {
          return tels;
     }

     public ObjectData<String> getMails() {
          return mails;
     }
     public ObjectData<String> getGroups() {
          return groups;
     }

}
