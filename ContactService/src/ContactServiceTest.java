import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void addContact() {
        Contact contact = new Contact("1234567890", "Mike", "Mathews", "6164668014", "257 Grand Rapids");
        contactService.addContact(contact);

        Contact retrieved = contactService.getContact("1234567890");
        assertNotNull(retrieved);
        assertEquals(contact.getContactID(), retrieved.getContactID());
    }


    @Test
    void deleteContact() {
        Contact contact = new Contact("1234567890", "Mike", "Mathews", "6164668014", "257 Grand Rapids");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    void updateContact() {
        Contact contact = new Contact("1234567890", "Mike", "Mathews", "1112223333", "257 Grand Rapids");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "Michael", "Michaels", "4445556666", "257 Updated Road");

        Contact updated = contactService.getContact("1234567890");
        assertEquals("Michael", updated.getFirstName());
        assertEquals("4445556666", updated.getPhoneNumber());
        assertEquals("257 Updated Road", updated.getAddress());
    }

    @Test
    void addDuplicateContactIDThrowsException() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234567890", "Mike", "Mathews", "6164668014", "257 Grand Rapids");
        Contact contact2 = new Contact("1234567890", "John", "Smith", "1112223333", "999 Broadway");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void deleteNonExistingContactDoesNotThrowException() {
        ContactService service = new ContactService();
        assertDoesNotThrow(() -> service.deleteContact("nonexistentID"));
    }

    @Test
    void updateNonexistentContactDoesNotWork() {
        ContactService service = new ContactService();
        assertFalse(service.updateContact("1234567890", "EMPTY","EMPTY",   "1234567890", "111 Mike Street"));
    }

    @Test
    void updateContactWithInvalidDataThrowsException() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "Mike", "Mathews", "6164668014", "257 Grand Rapids");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                service.updateContact("1234567890", "", "Math", "not valid right now", "address"));
    }

}
