package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemoveTests extends TestBase {

    @Test
    void canRemoveContact() {
        {
            if (!app.contact().isContactPresent()) {
                app.contact().createContact(new ContactData().withFioAndNumber("Andrew", "Marsy", "Sondors", "8098745792874"));
            } else {
                app.contact().removeContact();
            }
        }
    }
}