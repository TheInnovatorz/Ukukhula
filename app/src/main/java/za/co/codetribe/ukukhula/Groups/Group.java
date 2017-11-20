package za.co.codetribe.ukukhula.Groups;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Codetribe on 2017/11/10.
 */

public class Group implements Parcelable {

    private String GroupNane;
    String groupTeacher;


    public Group() {

    }

    public Group(String groupNane, String groupTeacher) {
        GroupNane = groupNane;
        groupTeacher = groupTeacher;
    }

    protected Group(Parcel in) {
        GroupNane = in.readString();
        groupTeacher = in.readString();
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

    public String getGroupNane() {
        return GroupNane;
    }

    public void setGroupNane(String groupNane) {
        GroupNane = groupNane;
    }

    public String getGroupTeacher() {
        return groupTeacher;
    }

    public void setGroupTeacher(String groupTeacher) {
        groupTeacher = groupTeacher;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Group names", GroupNane);
        result.put("Group teacher", groupTeacher);

        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(GroupNane);
        parcel.writeString(groupTeacher);
    }


}
