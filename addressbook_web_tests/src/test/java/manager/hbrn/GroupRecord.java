package manager.hbrn;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Table(name ="group_list")
@Entity
public class GroupRecord {


    @Id
    @Column(name = "group_id")
    public int id;
    @Column(name = "group_name")
    public String name;
    @Column(name = "group_header")
    public String header;
    @Column(name = "group_footer")
    public String footer;


    public GroupRecord() {
    }

    public GroupRecord(int id, String name, String header, String footer) {

        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }
}