package tests;

import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @Test
    void canModificateGroup(){
        if (app.hbrn().getGroupCount() == 0) {
            app.hbrn().createGroup(new GroupData("", "fam", "fam header", "fam footer"));
        }
        var oldGroups = app.hbrn().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName(CommonFunctions.randomString(8));
        app.groups().modifyGroup(oldGroups.get(index), testData);
        var newGroups = app.hbrn().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index,testData.withId(oldGroups.get(index).id()));
        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));
    }
}
