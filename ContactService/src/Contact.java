public class Contact {

     private final String contactID;
     private String firstName;
     private String lastName;
     private String phoneNumber;
     private String address;

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if(contactID == null || contactID.isEmpty() || contactID.length() > 10){
            throw new IllegalArgumentException("Invalid contact ID");
        }
        this.contactID = contactID;
        if(firstName == null || firstName.isEmpty() || firstName.length() > 10){
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
        if(lastName == null || lastName.isEmpty() || lastName.length() > 10){
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
        if(phoneNumber.length() != 10){
            throw new IllegalArgumentException("Invalid phone number");

        }
        this.phoneNumber = phoneNumber;
        if(address == null || address.length() > 30){
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }

    public String getContactID() { return contactID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");

        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10)
            throw new IllegalArgumentException("Invalid phone number");

        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        this.address = address;
    }

}
