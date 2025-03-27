package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemoveTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("fam", "fam header", "fam footer"));
        } else {

            app.groups().removeGroup();
        }
    }
}
