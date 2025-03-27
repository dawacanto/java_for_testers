package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModificateGroup(){
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("fam", "fam header", "fam footer"));
        }
        app.groups().modifyGroup(new GroupData().withName("name2"));
    }
}
