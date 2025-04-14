package manager;
import manager.hbrn.GroupRecord;
import model.GroupData;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;


public class HibernateHelper extends HelperBase{

   private SessionFactory sessionFactory;
    public HibernateHelper (ApplicationManager manager){
        super(manager);

        this.sessionFactory = new Configuration()
                        .addAnnotatedClass(GroupRecord.class)
                        .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook")
                        .setProperty(AvailableSettings.USER, "root")
                        .setProperty(AvailableSettings.PASS, "")
                        .buildSessionFactory();
    }

    static List<GroupData> convertList(List<GroupRecord> records){
    List<GroupData> result = new ArrayList<>();
        for (var record: records){
            result.add(convert(record));
        } return result;
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        return new GroupRecord(Integer.parseInt(data.id()), data.name(), data.header(), data.footer());
    }

    public List<GroupData> getGroupList(){
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord",GroupRecord.class).list();
        }));
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord",long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.persist(convert(groupData));
        });
    }
}
