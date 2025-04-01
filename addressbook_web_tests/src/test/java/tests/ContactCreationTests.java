package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test

    public void canContactCreate (){
        app.contact().createContact(new ContactData().withFioAndNumber("Mick", "Alex", "Blackbird", "+7898678652"));
    }


}

