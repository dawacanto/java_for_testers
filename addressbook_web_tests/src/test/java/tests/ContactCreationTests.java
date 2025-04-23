package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static tests.TestBase.app;
import static tests.TestBase.randomFile;

public class ContactCreationTests extends TestBase {


    public static List <ContactData> ContactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        //for (int i = 0; i <3; i++){
         //   result.add(new ContactData().withFioAndNumber(CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*2),CommonFunctions.randomString(i*4),CommonFunctions.randomString(i*3)));
       // }
        var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>(){});
        result.addAll(value);
        return result;
    }
@Test

    void canCreateContact(){
        var contact = new ContactData()
                .withFioAndNumber(CommonFunctions.randomString(6), CommonFunctions.randomString(6), CommonFunctions.randomString(6), CommonFunctions.randomString(6))
                .withPhoto(randomFile("src/test/resources/images/"));
        app.contact().createContact(contact);
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


@Test

void canCreateContactInGroup(){
    var contact = new ContactData()
            .withFioAndNumber(CommonFunctions.randomString(6), CommonFunctions.randomString(6), CommonFunctions.randomString(6), CommonFunctions.randomString(6))
            .withPhoto(randomFile("src/test/resources/images/"));
    if(app.hbrn().getGroupCount() == 0) {
        app.hbrn().createGroup(new GroupData("", "fam", "fam header", "fam footer"));
    }   var group = app.hbrn().getGroupList().get(0);

    var oldRelated = app.hbrn().getContactsInGroup(group);
    app.contact().createContact(contact, group);
    var newRelated = app.hbrn().getContactsInGroup(group);
    Assertions.assertEquals(oldRelated.size()+1, newRelated.size());//!!!но нужно сравнивать также содержимое
}

}