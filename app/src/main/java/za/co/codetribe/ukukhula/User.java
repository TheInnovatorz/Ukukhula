package za.co.codetribe.ukukhula;

/**
 * Created by User8 on 11/13/2017.
 */

public class User {

    private String address,className,contacts,email,gender,id_number,name,password,qualifications,surname,user_role;

    public User() {
    }

    public User(String address, String className, String contacts, String email, String gender, String id_number, String name, String password, String qualifications, String surname, String user_role) {
        this.address = address;
        this.className = className;
        this.contacts = contacts;
        this.email = email;
        this.gender = gender;
        this.id_number = id_number;
        this.name = name;
        this.password = password;
        this.qualifications = qualifications;
        this.surname = surname;
        this.user_role = user_role;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}
