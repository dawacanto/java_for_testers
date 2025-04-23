package manager.hbrn;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;

    public int domain_id;
    public String firstname;
    public String middlename;
    public String lastname;
    public String nickname;
    public String company;
    public String title;
    public String address;
    public String home;
    public String mobile;
    public String work;
    public String fax;
    public String email;
    public String email2;
    public String email3;
    public String homepage;
    public int bday;
    public String bmonth;
    public String byear;
    public int aday;
    public String amonth;
    public String ayear;

    public Date created;
    public Date modified;

    public ContactRecord() {}

    public ContactRecord(int id, String firstname, String lastname, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}
