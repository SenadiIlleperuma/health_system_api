//@author Senadi Illeperuma
//IIT no: 20220678 

package dao;

import java.util.ArrayList;
import model.Person;

public class PersonDAO {
    private static ArrayList<Person> personArray = new ArrayList<>();

    //retrieve all the persons
    public ArrayList<Person> getAllPersons() {
        return personArray;
    }

    //retrieve a person using the ID
    public Person getbyID(int id) {
        for (Person person : personArray) {
            if (person.getID() == id) {
                return person;
            }
        }
        return null;
    }

    //add a person to the system
    public void addPerson(Person person) {
        personArray.add(person);
    }

    //update a person to the system
    public void updatePerson(Person updatedPerson) {
        for (Person person : personArray) {
            if (person.getID() == updatedPerson.getID()) {
                person.setName(updatedPerson.getName());
                person.setContactInfo(updatedPerson.getContactInfo());
                person.setAddress(updatedPerson.getAddress());
            }
        }
    }

    //deletes a person using the ID
     public void deletePerson(int id) {
          Person personTodelete = null;
          for (Person person : personArray) {
              if (person.getID() == id) {
                  personTodelete = person;
                  break;
              }
          }
          if (personTodelete != null) {
              personArray.remove(personTodelete);
          }
      }
   
}
