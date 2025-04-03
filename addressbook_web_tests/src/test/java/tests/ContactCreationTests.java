package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test

    public void canContactCreate() {
        app.contact().createContact(new ContactData().withFioAndNumber("Mick", "Alex", "Blackbird", "+7898678652"));
    }

    public static List<ContactData> ContactProvider(){
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < 5; i++){
            result.add(new ContactData(randomString(i*4), randomString(i*5),randomString(i*3),randomString(i*4), randomString(i*5),randomString(i*3),randomString(i*4), randomString(i*5),randomString(i*3),randomString(i*4), randomString(i*5),randomString(i*3),randomString(i*4), randomString(i*5),randomString(i*3),"", "","","","",""));
        }
        return result;

    }

    @ParameterizedTest
    @MethodSource("ContactProvider")
    public void canCreatManyContacts(ContactData contact) {
        int contactCount = app.contact().getCount();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals (contactCount+1, newContactCount);
    }
}

