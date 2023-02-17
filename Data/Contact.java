package Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Contact {
     private UUID id;
     private String name;
     private Collection<String> tels = new ArrayList<>();
     private Collection<String> mails = new ArrayList<>();
     private Collection<String> groups = new ArrayList<>();
     private Melody melody;

     public Contact() {
     }

     public Contact(String name, String tel) {
          this.id = UUID.randomUUID();
          this.name = name;
          setTel(tel);
     }

     public static Contact buildContact(String name, String tel, String mail,String group) {
          Contact сontact = new Contact();

          сontact.setId(UUID.randomUUID());
          сontact.setName(name);
          сontact.setTel(tel);
          сontact.setMail(mail);
          сontact.setGroup(group);
          return сontact;
     }

     private void setId(UUID id) {
          this.id = id;
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

     public void setTel(String tel) {
          if (!tels.contains(tel))
               tels.add(tel);
     }
     public Collection<String> getTels() {
          return tels;
     }
     public void replaceTel(String oldTel, String tel) {
          if ( tels.contains(oldTel))
               tels.remove(oldTel);

          setTel(tel);
     }

     

     public void setMail(String mail) {
          if (!mails.contains(mail))
               mails.add(mail);
     }

     public Collection<String> getMails() {
          return mails;
     }

     public void replaceMail(String oldMail, String mail) {
          if ( mails.contains(oldMail))
               mails.remove(oldMail);

          setMail(mail);
     }

     public void setGroup(String group) {
          if (!groups.contains(group))
               groups.add(group);
     }

     public Collection<String> getGroup() {
          return groups;
     }

     public void replaceGroup(String oldGroup, String group) {
          if (groups.contains(oldGroup))
               groups.remove(oldGroup);

          setGroup(group);
     }
}
