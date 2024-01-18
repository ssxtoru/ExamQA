import java.io.*;
import java.util.Scanner;

public class ContactManager {
    private Contact [] contacts;
    private int size =  0;

    public ContactManager(int I) {
        contacts = new Contact[100];
        size = 0;
    }
    public void addContact(Contact contact) {
        if (size < contacts.length) {
            contacts[size++] = contact;
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Maximum number of contacts reached. Cannot add more contacts.");
        }
    }

    public void displayContacts() {
        if (size == 0) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts:");
            for (int i = 0; i < size; i++) {
                System.out.println((i + 1) + ". " + contacts[i].displayContact());
            }
        }
    }
    public Contact findContact(String searchTerm) {
        String searchTermLowerCase = searchTerm.toLowerCase();
        for (int i = 0; i < size; i++) {
            String nameLowerCase = contacts[i].getName().toLowerCase();
            String phoneNumberLowerCase = contacts[i].getPhoneNumber().toLowerCase();

            if (nameLowerCase.equals(searchTermLowerCase) || phoneNumberLowerCase.equals(searchTermLowerCase)) {
                return contacts[i];
            }
        }
        return null;
    }
    public int getSize() {
        return size;
    }

    public Contact getContact(int index) {
        if (index >= 0 && index < size) {
            return contacts[index];
        }
        return null;
    }

    public void updateContact(Contact contact, String firstName, String lastName, String phoneNumber, String email) {
        contact.updateContact(firstName, lastName, phoneNumber, email);
        System.out.println("Contact updated successfully!");
    }

    public void deleteContact(Contact contact) {
        int index = indexOfContact(contact);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                contacts[i] = contacts[i + 1];
            }
            size--;
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private int indexOfContact(Contact contact) {
        for (int i = 0; i < size; i++) {
            if (contacts[i] == contact) {
                return i;
            }
        }
        return -1;
    }

    public void saveContactsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < size; i++) {
                Contact contact = contacts[i];
                writer.println(contact.getName() + "," +
                        contact.getSurname() + "," +
                        contact.getPhoneNumber() + "," +
                        contact.getEmail());
            }
            System.out.println("Contacts saved to " + filename + " successfully!");
        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    public void loadContactsFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] contactData = line.split(",");
                if (contactData.length == 4) {
                    String name = contactData[0].trim();
                    String surname = contactData[1].trim();
                    String phoneNumber = contactData[2].trim();
                    String email = contactData[3].trim();

                    Contact contact = new Contact(name, surname, phoneNumber, email);
                    addContact(contact);
                }
            }
            System.out.println("Contacts loaded from " + filename + " successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}
