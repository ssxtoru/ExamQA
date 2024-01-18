public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public Contact(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void updateContact(String newName, String newSurname, String newPhoneNumber, String newEmail) {
        this.name = newName;
        this.surname = newSurname;
        this.phoneNumber = newPhoneNumber;
        this.email = newEmail;
    }
    public String displayContact() {
        return "Contact- " +
                "\n  Name:       " + name +
                "\n  Surname:    " + surname +
                "\n  Phone:      " + phoneNumber +
                "\n  Email:      " + email +
                "\n";
    }


}
