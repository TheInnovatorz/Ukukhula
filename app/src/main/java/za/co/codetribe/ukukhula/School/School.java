package za.co.codetribe.ukukhula.School;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class School implements Parcelable {

    private String year;
    private String schoolname;
    private String schooladdress;
    private String schoolmanager;
    private String contactdetails;
    private String emailaddress;

    // Children button will add it later once we have the right structure


    public School() {

    }

    public School(String year, String schoolname,String schooladdress, String schoolmanager, String contactdetails, String emailaddress) {
        this.year=year;
        this.schoolname = schoolname;
        this.schooladdress = schooladdress;
        this.schoolmanager = schoolmanager;
        this.contactdetails = contactdetails;
        this.emailaddress = emailaddress;
    }

    protected School(Parcel in) {
        year = in.readString();
        schoolname = in.readString();
        schooladdress = in.readString();
        schoolmanager = in.readString();
        contactdetails = in.readString();
        emailaddress = in.readString();
    }

    public static final Creator<School> CREATOR = new Creator<School>() {
        @Override
        public School createFromParcel(Parcel in) {
            return new School(in);
        }

        @Override
        public School[] newArray(int size) {
            return new School[size];
        }
    };

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSchooladdress() {
        return schooladdress;
    }

    public void setSchooladdress(String schooladdress) {
        this.schooladdress = schooladdress;
    }

    public String getSchoolmanager() {
        return schoolmanager;
    }

    public void setSchoolmanager(String schoolmanager) {
        this.schoolmanager = schoolmanager;
    }

    public String getContactdetails() {
        return contactdetails;
    }

    public void setContactdetails(String contactdetails) {
        this.contactdetails = contactdetails;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("year", year);
        result.put("School_Name", schoolname);
        result.put("School_Address", schooladdress);
        result.put("School_Manager", schoolmanager);
        result.put("Contact-Details", contactdetails);
        result.put("Email_address", emailaddress);
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(year);
        dest.writeString(schoolname);
        dest.writeString(schooladdress);
        dest.writeString(schoolmanager);
        dest.writeString(contactdetails);
        dest.writeString(emailaddress);
    }
//    public School(Parcel in){
//        this.year = in.readString();
//        this.schoolname=in.readString();
//        this.schooladdress=in.readString();
//        this.schoolmanager=in.readString();
//        this.contactdetails=in.readString();
//        this.emailaddress=in.readString();
//    }
}

