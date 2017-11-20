package za.co.codetribe.ukukhula.learner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import za.co.codetribe.ukukhula.R;

public class ViewLearnerActivity extends AppCompatActivity {

    EditText  className,names, surname,date_of_birth,allegies,parentName, contacts,  favouriteMeal;
    //LearnerProfile object;
    Spinner gender;
    //EditText  className,names, surname, gender,date_of_birth,allegies,parentName, contacts,  favouriteMeal;
    LearnerProfile object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kidsprofile);

        object = (LearnerProfile) getIntent().getParcelableExtra("data");

       String name= object.getClassName();



        Log.i("MODISEAVIWE", object.getClassName());



        names = (EditText) findViewById(R.id.editname);
        surname = (EditText) findViewById(R.id.editsurname);
        allegies = (EditText) findViewById(R.id.editallergies);
        gender = (Spinner) findViewById(R.id.editgender);
        parentName = (EditText) findViewById(R.id.editparentName);
        contacts = (EditText) findViewById(R.id.editContacts);
        className = (EditText) findViewById(R.id.editClassName);
        date_of_birth = (EditText) findViewById(R.id.editdate);
        favouriteMeal = (EditText) findViewById(R.id.editfavmeal);



        names.setText(object.getNames());
        surname.setText(object.getSurname());
        className.setText(object.getClassName());
//        gender.setText(object.getGender());
        String gende= gender.getSelectedItem().toString();
        parentName.setText(object.getParentName());
        contacts.setText(object.getContacts());
        allegies.setText(object.getAllegies());
        date_of_birth.setText(object.getDate_of_birth());
        favouriteMeal.setText(object.getFavouriteMeal());
    }
}
