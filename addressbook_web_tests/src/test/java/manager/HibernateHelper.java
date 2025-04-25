package manager;
import manager.hbrn.ContactRecord;
import manager.hbrn.GroupRecord;
import model.ContactData;
import model.ContactGroupBind;
import model.GroupData;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        this.sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=CONVERT_TO_NULL")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<ContactData> convertListContact(List<ContactRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    static List<GroupData> convertListGroup(List<GroupRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    public static ContactData convert(ContactRecord record) {
        return new ContactData("" + record.id, record.firstname, record.middlename, record.lastname, record.nickname, "", record.title, record.company, record.address, record.home, record.mobile, record.work, record.fax, record.email, record.email2, record.email3, record.homepage, "" + record.bday, record.bmonth, record.byear, "" + record.aday, record.amonth, record.ayear
        );
    }

    // private static ContactRecord convert (ContactData data){
    //   var id = data.id();
    // if("".equals(id)){
    //   id = "0";
    //}return new ContactRecord(Integer.parseInt(id), data.firstname(), data.lastname(), data.address());
    //}

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    private static ContactRecord convert(ContactData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactRecord(Integer.parseInt(id), data.firstname(), data.middlename(), data.lastname(), data.nickname(), data.photo(), data.title(), data.company(), data.address(), data.home(), data.mobile(), data.work(), data.fax(), data.email(), data.email2(), data.email3(), data.homepage(), Integer.parseInt(data.bday()), data.bmonth(), data.byear(), Integer.parseInt(data.aday()), data.amonth(), data.ayear());
    }

    static List<ContactData> converterContactList(List<ContactRecord> records) {
        List<ContactData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }


    public List<ContactRecord> getContactList() {
        return (sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    public List<GroupData> getGroupList() {
        return convertListGroup((List<GroupRecord>) sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }


    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", long.class).getSingleResult();
        });
    }

    public long getContactCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });
    }

    public void createContact(ContactData contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(contactData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            return converterContactList(session.get(GroupRecord.class, group.id()).contacts);
        });
    }

    public List<ContactGroupBind> getAllContactGroupBinds() {
        try {
            return sessionFactory.fromSession(session -> {
                List<GroupRecord> groups = session.createQuery("from GroupRecord", GroupRecord.class).list();
                List<ContactGroupBind> result = new ArrayList<>();
                for (GroupRecord group : groups) {
                    for (ContactRecord contact : group.contacts) {
                        result.add(new ContactGroupBind(contact.id, group.id));
                    }
                }
                return result;
            });
        } catch (IllegalStateException e) {
            System.out.println("Нет ни одной связи в address_in_groups: " + e.getMessage());
            return Collections.emptyList();
        }


    }
}
