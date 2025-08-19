import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ContactService {
    public String contactID;
    public String contactFirstName;
    public String contactLastName;
    public String contactAddress;
    public String contactPhone;
    Scanner scanner = new Scanner(System.in);

    public List<Contact> contactList = new ArrayList<Contact>();

    public void addContact(Contact contact) {
        for(Contact c: contactList) {
            if(c.getContactID().equals(contact.getContactID())) {
                throw new IllegalArgumentException("Duplicate Contact. Cannot Add.");
            }
        }
        contactList.add(contact);
    }

    public boolean deleteContact(String contactID) {

        return contactList.removeIf(contact -> Objects.equals(contact.getContactID(), contactID));
    }

    public boolean updateContact(String contactID, String contactFirstName, String contactLastName, String contactPhone, String contactAddress) {
        for(Contact contact : contactList){
            if(Objects.equals(contact.getContactID(), contactID)){
                contact.setFirstName(contactFirstName);
                contact.setLastName(contactLastName);
                contact.setPhoneNumber(contactPhone);
                contact.setAddress(contactAddress);
                return true;
            }
        }
        return false;
    }

    public Contact getContact(String contactID) {
        for(Contact contact : contactList){
            if(Objects.equals(contact.getContactID(), contactID)){
                return contact;
            }
        }
        return null;
    }


}
