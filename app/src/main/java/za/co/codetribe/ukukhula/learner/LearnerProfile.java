package za.co.codetribe.ukukhula.learner;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.Transaction;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.name;
import static android.R.attr.type;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Codetribe on 2017/10/25.
 */

public class LearnerProfile implements Parcelable {

    private String names;
    private String surname;
    private String allegies;
    private String date_of_birth;
    private String parentName;
    String contacts;
    String gender;
    String className;
    String favouriteMeal;

   // private MySubParcelable mInfo;

    // Children but will add it later once we have the right structure


    public LearnerProfile() {
    }

    public LearnerProfile(String names, String surname, String allegies, String date_of_birth, String parentName, String contacts, String gender, String className, String favouriteMeal) {
        this.names = names;
        this.surname = surname;
        this.allegies = allegies;
        this.date_of_birth = date_of_birth;
        this.parentName = parentName;
        this.contacts = contacts;
        this.gender = gender;
        this.className = className;
        this.favouriteMeal = favouriteMeal;
    }

    protected LearnerProfile(Parcel in) {
        names = in.readString();
        surname = in.readString();
        allegies = in.readString();
        date_of_birth = in.readString();
        parentName = in.readString();
        contacts = in.readString();
        gender = in.readString();
        className = in.readString();
        favouriteMeal = in.readString();
    }

    public static final Creator<LearnerProfile> CREATOR = new Creator<LearnerProfile>() {
        @Override
        public LearnerProfile createFromParcel(Parcel in) {
            return new LearnerProfile(in);
        }

        @Override
        public LearnerProfile[] newArray(int size) {
            return new LearnerProfile[size];
        }
    };

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAllegies() {
        return allegies;
    }

    public void setAllegies(String allegies) {
        this.allegies = allegies;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFavouriteMeal() {
        return favouriteMeal;
    }

    public void setFavouriteMeal(String favouriteMeal) {
        this.favouriteMeal = favouriteMeal;
    }

//    @Exclude
//    public Map<String, Object> toMap() {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("names", names);
//        result.put("surname", surname);
//        result.put("contact_number", contacts);
//        result.put("date_of_birth", date_of_birth);
//        result.put("favouriteMeal", favouriteMeal);
//        result.put("gender",Gender);
//        result.put("allegies",allegies);
//        result.put("parentName",parentName);
//        result.put("className",className);
//
//
//
//        return result;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(names);
        parcel.writeString(surname);
        parcel.writeString(contacts);
        parcel.writeString(date_of_birth);
        parcel.writeString(favouriteMeal);
        parcel.writeString(gender);
        parcel.writeString(allegies);
        parcel.writeString(parentName);
        parcel.writeString(className);

    }

}
