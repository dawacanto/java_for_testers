package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificateTests extends TestBase {

    @Test

    public void canModifyContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData().withFioAndNumber("Andrew", "Mark", "Sonders", "8098745792874"));
        }
        app.contact().modifyContact(new ContactData().withFullFields("Andy", "Mick", "Sonder", "stich", "bro", "SROSanches", "Fandys, 8,4", "76845633", "3338677", "3535353", "9995643", "mando@jkd.com", "test@mls.com", "lnlsls@test.com", "4kpinf.com", "2", "January", "2008", "18", "July", "2000"));
    }
}