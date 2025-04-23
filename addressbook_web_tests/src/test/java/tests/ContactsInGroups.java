package tests;

import manager.HibernateHelper;
import model.ContactData;
import model.ContactGroupBind;
import model.GroupData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ContactsInGroups extends TestBase{

    @Test
    public void canBindContact() {
        if (app.hbrn().getContactCount()==0) {
            app.hbrn().createContact(new ContactData("", "Alice", "Marie", "Johnson", "aj", "", "QA Engineer", "TechCorp", "123 Main St, Springfield", "555-0001", "555-1234", "555-4321", "555-9999", "alice@company.com", "aj@altmail.com", "aj.third@mail.com", "www.alicejohnson.com", "15", "March", "1990", "20", "July", "2025"));
        }if (app.hbrn().getGroupCount() == 0) {
            app.hbrn().createGroup(new GroupData("0", "fam", "fam header", "fam footer"));
        }var groupsInBase = app.hbrn().getGroupList();
        var contactsInBase =app.hbrn().getContactList();
        var rndGr = new Random();
        var rndCn = new Random();
        var indexGr = rndGr.nextInt(groupsInBase.size());
        var indexCn = rndCn.nextInt(contactsInBase.size());
        var randomGroup = groupsInBase.get(indexGr);
        var randomContact = app.hbrn().convert(contactsInBase.get(indexCn));
        app.contact().bindWithGroup(randomContact, randomGroup);
        var updatedGroupContacts = app.hbrn().getContactsInGroup(randomGroup);
        assertTrue(updatedGroupContacts.contains(randomContact));
    }

    @Test
    public void canUnbindContactFromGroup() {

        if (app.hbrn().getGroupCount() == 0) {
            app.hbrn().createGroup(new GroupData("", "testGroup", "header", "footer"));
        }
        if (app.hbrn().getContactCount() == 0) {
            app.hbrn().createContact(new ContactData("", "Alice", "Marianne", "Johnson", "aj", "", "QA Engineer", "TechCorp", "123 Main St, Springfield", "555-0001", "555-1234", "555-4321", "555-9999", "alice@company.com", "aj@altmail.com", "aj.third@mail.com", "www.alicejohnson.com", "15", "March", "1990", "20", "July", "2025"));
        }
        List<ContactGroupBind> binds = app.hbrn().getAllContactGroupBinds();
        if (binds.isEmpty()) {
            var group = app.hbrn().getGroupList().get(0);
            app.hbrn();
            var contact = HibernateHelper.convert(app.hbrn().getContactList().get(0));
            app.contact().bindWithGroup(contact, group);
            binds = app.hbrn().getAllContactGroupBinds();
        }

        var rnd = new Random();
        var index = rnd.nextInt(binds.size());
        ContactGroupBind bindToRemove = binds.get(index);
        app.contact().unbindContact(bindToRemove);
        List<ContactGroupBind> updatedBinds = app.hbrn().getAllContactGroupBinds();
        assertFalse(updatedBinds.contains(bindToRemove), "Связь не была удалена из address_in_groups!");
    }
}
