package Sem6_6;

import java.util.ArrayList;
import java.util.HashMap;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
      if (phoneBook.containsKey(name)){
        ArrayList <Integer> temp = new  ArrayList<>(phoneBook.get(name));
        temp.add(phoneNum);
        phoneBook.put(name, temp);
      }
      else{
        ArrayList <Integer> temp = new  ArrayList<>();
        temp.add(phoneNum);
        phoneBook.put(name, temp);
      }
    }

    public void remove(String name){
      if (phoneBook.containsKey(name))
        phoneBook.remove(name);  
    }

    public ArrayList<Integer> find(String name) {
      if (phoneBook.containsKey(name)){
        return phoneBook.get(name);    
      } 
      else{
        ArrayList <Integer> temp = new  ArrayList<>();
        return temp;
      }
    }

    public void getPhoneBook() {
      int max = 0;
      for (String k : phoneBook.keySet()){
        if (max < phoneBook.get(k).size()){
          max = phoneBook.get(k).size();
        }
      }
      for (int i = max; i > 0; i--){
        for (String j : phoneBook.keySet()){
          if (i == phoneBook.get(j).size())
            System.out.println(j + " " + phoneBook.get(j));
        } 
      }
    }

}



public class MapDZ {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Ivanov", 123456);
        myPhoneBook.add("Ivanov", 654321);
        myPhoneBook.add("Petrov", 654321);
        myPhoneBook.add("Dubov", 1233456);
        myPhoneBook.add("Dubov", 6543321);
        myPhoneBook.add("Dubov", 65433111);


        System.out.println(myPhoneBook.find("Ivanov"));
        myPhoneBook.getPhoneBook();
        myPhoneBook.remove("Ivanov");
        System.out.println(myPhoneBook.find("Ivanov"));
        myPhoneBook.getPhoneBook();


    }
}

