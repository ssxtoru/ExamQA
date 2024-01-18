import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager(100);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            try {
                System.out.println("===========PhoneBook==========");
                System.out.println("= 1. Add Contact             =");
                System.out.println("= 2. Display Contacts        =");
                System.out.println("= 3. Find Contact            =");
                System.out.println("= 4. Update Contact          =");
                System.out.println("= 5. Delete Contact          =");
                System.out.println("= 6. Save contacts to file   =");
                System.out.println("= 7. Load contacts from file =");
                System.out.println("= 8. Exit                    =");
                System.out.println("==============================");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter surname: ");
                        String surname = scanner.nextLine();

                        System.out.print("Enter phone number: ");
                        String phoneNumber = scanner.nextLine();

                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();

                        Contact newContact = new Contact(name, surname, phoneNumber, email);
                        contactManager.addContact(newContact);
                        break;

                    case 2:
                        contactManager.displayContacts();
                        break;

                    case 3:
                        System.out.print("Enter name or phone number to search: ");
                        String searchTerm = scanner.nextLine();
                        Contact foundContact = contactManager.findContact(searchTerm);
                        if (foundContact != null) {
                            System.out.println("Contact found:");
                            System.out.println(foundContact.displayContact());
                        } else {
                            System.out.println("Contact not found.");
                        }
                        break;

                    case 4:
                        contactManager.displayContacts();
                        System.out.print("Enter the index of the contact to update: ");
                        int updateIndex = scanner.nextInt();
                        scanner.nextLine();
                        updateIndex --;
                        if (updateIndex >= 0 && updateIndex < contactManager.getSize()) {
                            Contact contactToUpdate = contactManager.getContact(updateIndex);

                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();

                            System.out.print("Enter new surname: ");
                            String newSurname = scanner.nextLine();

                            System.out.print("Enter new phone number: ");
                            String newPhoneNumber = scanner.nextLine();

                            System.out.print("Enter new email: ");
                            String newEmail = scanner.nextLine();

                            contactManager.updateContact(contactToUpdate, newName, newSurname, newPhoneNumber, newEmail);
                        } else {
                            System.out.println("Invalid index.");
                        }
                        break;

                    case 5:
                        contactManager.displayContacts();
                        System.out.print("Enter the index of the contact to delete: ");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine();
                        deleteIndex --;
                        if (deleteIndex >= 0 && deleteIndex < contactManager.getSize()) {
                            Contact contactToDelete = contactManager.getContact(deleteIndex);
                            contactManager.deleteContact(contactToDelete);
                        } else {
                            System.out.println("Invalid index.");
                        }
                        break;
                    case 6:
                        contactManager.saveContactsToFile("Contact1.txt");
                        break;

                    case 7:
                        contactManager.loadContactsFromFile("Contact1.txt");
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 8);
    }
}