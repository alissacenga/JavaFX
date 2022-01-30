package application.bookstore.models;

import java.io.*;
import java.util.ArrayList;

public class Author implements BaseModel, Serializable {
    @Serial
    private static final long serialVersionUID = 1234567L;
    private String firstName;

    private String lastName;

    private static final ArrayList<Author> authors = new ArrayList<>();

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public Author(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean saveInFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("authors.ser", true))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        authors.add(this);
        return true;
    }

    public static ArrayList<Author> getAuthors() {
        if (authors.size() == 0) {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("authors.ser"));
                while (true) {
                    Author temp = (Author) inputStream.readObject();
                    if (temp != null)
                        authors.add(temp);
                    else
                        break;
                }
                inputStream.close();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        return authors;
    }
}
