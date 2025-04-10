package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List <ContactData> ContactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i <5; i++){
            result.add(new ContactData().withNameLastname(CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*2)));
        }
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
}

