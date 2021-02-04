package online.irishdictionary.model;

public class ContactForm {

    private String name = null;
    private String email = null;
    private String message = null;

    public ContactForm(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMessage() {
        return this.message;
    }

    public void getName(String name) {
        this.name = name;
    }

    public void getEmail(String email) {
        this.email = email;
    }

    public void getMessage(String message) {
        this.message = message;
    }
}
