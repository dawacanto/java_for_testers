package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {


    @Test
    public void GroupCreation() {
        app.groups().createGroup(new GroupData("fam", "fam header", "fam footer"));

    }

    @Test
    public void GroupCreationEmptyName() {
        app.driver.findElement(By.linkText("groups")).click();
        app.groups().createGroup(new GroupData());

    }

    @Test
    public void GroupCreationWithName() {
        app.groups().createGroup(new GroupData().withName("some name"));

    }

    @Test
    public void GroupCreationWithHeader() {
        app.groups().createGroup(new GroupData().withHeader("some name"));

    }

    @Test
    public void GroupCreationWithFooter() {
        app.groups().createGroup(new GroupData().withFooter("some name"));

    }
}
