package manager;

import model.ContactData;
import org.openqa.selenium.By;

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
        selecter("aday", contact.aday());
        selecter("amonth", contact.amonth());
        type(By.name("ayear"), contact.ayear());
        selecter("bday", contact.bday());
        selecter("bmonth", contact.bmonth());
        type(By.name("byear"), contact.byear());
    }

    public void modifyContact(ContactData modifiedContact) {
        openHomePage();
        selectContact();
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    public void removeContact() {
        openHomePage();
        selectContact();
        removeSelectedContact();
        returnToHomePage();
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void initContactModification(){
            click(By.xpath("//*[@title='Edit']"));
        }

        private void removeSelectedContact(){
            click(By.xpath("//*[@value='Delete']"));
        };

    private void submitContactModification(){
        click(By.name("update"));
    }
    private void submitContactCreation(){
        click(By.name("submit"));
    }

    private void returnToHomePage(){
        click(By.linkText("home"));
    }
}






