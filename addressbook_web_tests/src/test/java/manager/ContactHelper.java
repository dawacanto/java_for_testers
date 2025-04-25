package manager;

import model.ContactData;
import model.ContactGroupBind;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addContact() {
        click(By.linkText("add new"));
    }

    public void createContact(ContactData contact) {
        openHomePage();
        addContact();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void createContact(ContactData contact, GroupData group) {
        openHomePage();
        addContact();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());    }


    private void openHomePage() {
        if (!manager.isElementPresent(By.xpath("//*[text()='All phones']"))){
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }
    public void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        //attach(By.name("photo"), contact.photo());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("fax"), contact.fax());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
        selecter("aday", "-");
        selecter("amonth", "-");
        type(By.name("ayear"), contact.ayear());
        selecter("bday", "-");
        selecter("bmonth", "-");
        type(By.name("byear"), contact.byear());
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    public void removeAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContact();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[type='checkbox'][name='selected[]'][value='%s']", contact.id())));
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox: checkboxes){
            checkbox.click();
        }
    }

    private void initContactModification(ContactData contact){
        String id = contact.id();
        click(By.xpath("//a[contains(@href, 'edit.php?id=" + id + "')]"));
        }

        private void removeSelectedContact(){
            click(By.xpath("//*[@value='Delete']"));
        }

    private void submitContactModification(){
        click(By.name("update"));
    }
    private void submitContactCreation(){
        click(By.name("submit"));
    }

    private void returnToHomePage(){
        click(By.linkText("home"));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var tr: trs){
            var innerTag = tr.findElements(By.tagName("td"));
            var firstname = innerTag.get(2).getText();
            var lastname = innerTag.get(1).getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withNameLastname(firstname,lastname));
        }
        return contacts;
    }

    public void bindWithGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectContact(contact);
        bindToGroup(group);
        openSelectedGroup();

    }

    private void openSelectedGroup() {
        click(By.partialLinkText("group page"));
    }

    private void bindToGroup(GroupData group) {
        click(By.name("to_group"));
        click(By.cssSelector("select[name='to_group'] option[value='" + group.id() + "']"));
        click(By.name("add"));
    }

    public void unbindContact(ContactGroupBind bindToRemove) {
        openHomePage();
        selectNeededGroup(bindToRemove);
        removeFromGroup(bindToRemove);

    }

    private void selectNeededGroup(ContactGroupBind bindToRemove) {
        WebElement dropdown = manager.driver.findElement(By.name("group"));
        dropdown.findElement(By.xpath(".//option[@value='"+bindToRemove.groupId+"']")).click();
    }

    private void removeFromGroup(ContactGroupBind bindToRemove) {
        click(By.cssSelector(String.format("input[type='checkbox'][name='selected[]'][value='%s']", bindToRemove.contactId)));
        //click(By.xpath("//input[@type='submit' and @name='remove' and contains(@value, 'Remove from')]"));
        click(By.xpath("//input[@name='remove'])[1]"));
    }

    public String getPhones(ContactData contact) {
        manager.driver.findElement(By.xpath(String.format("//input[@id='%s']", contact.id() ));

    }
}






