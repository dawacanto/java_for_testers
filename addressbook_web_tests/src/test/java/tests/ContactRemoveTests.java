package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemoveTests extends TestBase {

    @Test
    void canRemoveContact() {
        {
            if (!app.contact().isContactPresent()) {
                app.contact().createContact(new ContactData().withFioAndNumber("Andrew", "Marsy", "Sondors", "8098745792874"));
            } else {
                var oldContacts= app.contact().getList();
                var rnd = new Random();
                var index = rnd.nextInt(oldContacts.size());
                app.contact().removeContact(oldContacts.get(index));
                var newContacts= app.contact().getList();
                var expectedList = new ArrayList<>(oldContacts);
                expectedList.remove(index);
                Assertions.assertEquals(newContacts, expectedList);
            }
        }
    }

    @Test
    void canRemoveAllContacts(){
        if(app.contact().getCount() == 0){
            app.contact().createContact(new ContactData().withFioAndNumber("Androim", "Mars", "Sondors", "8098745792874"));
        }
        app.contact().removeAllContacts();
        var newContacts = app.contact().getList();
        Assertions.assertEquals(0, newContacts.size());

    }
}