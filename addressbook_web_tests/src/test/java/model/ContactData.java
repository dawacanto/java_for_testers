package model;

public record ContactData (String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear)
{

public ContactData() {
    this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","","","","" );
}

    public ContactData withFullFields (String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear) {return new ContactData (firstname, middlename, lastname, nickname, title, company, address, home,mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear, aday, amonth, ayear);
}

    public ContactData withFioAndNumber (String firstname, String middlename, String lastname, String mobile) {return new ContactData (firstname, middlename, lastname, this.nickname, this.title, this.company, this.address, this.home,mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear);
    }


    }