package manager.hbrn;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "addressbook")

public class ContactRecord{

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

    public java.util.Date created;
    public java.util.Date modified;

    //private String address2;
    //private String phone2;
    //private String notes;
    //public String addr_long;
    //public String addr_lat;
    //public String addr_status;
    //private String photo;
    //private String x_vcard;
    //private String x_activesync;
    //private LocalDateTime deprecated;
    //private String password;
    //private LocalDate login;
    //private String role;
    //public String im;
    //public String im2;
    //public String im3;



    public ContactRecord(){}

public ContactRecord (int id, String firstname, String lastname, String address) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
}

}
