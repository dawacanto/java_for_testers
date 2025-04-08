package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List <ContactData> ContactProvider(){
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < 5; i++){
            result.add(new ContactData().withNameLastname(randomString(i*3),randomString(i*2)));
        }
        return result;

    }

   @ParameterizedTest
    @MethodSource("ContactProvider")
   public void canCreatManyContacts(ContactData contact) {
        var oldContactList = app.contact().getList();
        app.contact().createContact(contact);
        var newContactsList = app.contact().getList();
       Comparator<ContactData> compareById = (o1, o2) -> {
           return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
       };
       newContactsList.sort(compareById);
        var expectedList = new ArrayList<>(oldContactList);
        expectedList.add(contact.withId(newContactsList.get(newContactsList.size()-1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals (expectedList, newContactsList);
    }
}

