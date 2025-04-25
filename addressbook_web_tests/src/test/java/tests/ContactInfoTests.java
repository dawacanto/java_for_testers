package tests;

import org.junit.jupiter.api.Test;

public class ContactInfoTests extends TestBase{

    @Test

    void TestPhones (){//добавить проверку на пустой список контактов
        var contacts = app.hbrn().getContactList();
        var contact = contacts.get(0);
        var phones = app.contact().getPhones(contact);
    }
}
