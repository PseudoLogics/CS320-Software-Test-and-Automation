import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

   @Test
    void createValidContact(){
       Contact contact = new Contact("1234567890","Mike","Mathews","6164668014","257 Palmer");
       assertEquals("1234567890", contact.getContactID());
       assertEquals("Mike", contact.getFirstName());
       assertEquals("Mathews", contact.getLastName());
       assertEquals("6164668014", contact.getPhoneNumber());
       assertEquals("257 Palmer", contact.getAddress());
   }

   @Test
   void failedCreationLongID(){
       assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901234567890","Mike","Mathews", "6164668014", "257 Palmer"));
   }

   @Test
    void failedCreationNullName(){
       assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "Mathews", "6164668014", "257 Palmer"));
   }

   @Test
    void failedWithEmptyPhoneNumber(){
       assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Mike", "Mathews", "", "257 Palmer"));
   }

   @Test
    void setInvalidPhoneNumberTooShort(){
       Contact contact = new Contact("1234567890", "Mike", "Mathews", "6164668014", "257 Palmer");
       assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("123"));
   }

   @Test
    void setInvalidAddressTooLong(){
       Contact contact = new Contact("1234567890", "Mike", "Mathews", "6164668014", "257 Palmer");
       assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This is my new address I am actually about to move to a new state at the end of this month after my wedding!"));
   }
}