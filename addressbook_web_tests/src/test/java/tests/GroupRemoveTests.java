package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemoveTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("fam", "fam header", "fam footer"));
        } else {
            int groupCount = app.groups().getCount();
            app.groups().removeGroup();
            int newGroupCount = app.groups().getCount();
            Assertions.assertEquals(groupCount - 1, newGroupCount);

        }
    }

    @Test
    void canRemoveAllGroups() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("famy", "famy header", "famy footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.groups().getCount());

    }
}