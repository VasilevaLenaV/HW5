package Data;

interface IContact {
     Contact buildContact(String name, String tel, String mail,String group);

     void replaceTel(String oldValue, String newValue);
}

