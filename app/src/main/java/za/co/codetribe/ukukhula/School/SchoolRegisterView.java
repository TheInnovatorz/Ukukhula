package za.co.codetribe.ukukhula.School;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

import za.co.codetribe.ukukhula.MainActivity;
import za.co.codetribe.ukukhula.R;
import za.co.codetribe.ukukhula.StartActivity;


public class SchoolRegisterView extends AppCompatActivity {


    String yea, schoolnam, schooladdr, schoolmanage, contactdetail, emailaddres;

    EditText year;
    EditText schoolname;
    EditText schooladdress;
    //= (EditText) findViewById(R.id.school_address);
    EditText schoolmanager;
    EditText contactdetails;
    EditText emailaddress;
    Button save;
    //    CircleImageView profilePic;
    ImageView profileImgPallete;
    Button view;

    //authntification fields

    DatabaseReference roofdef, demodef, mDatabase, userDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseAuth.AuthStateListener mAuthListerner;
    School school;

    //images
    Uri imageUri;
    FloatingActionButton upload;
    private final int PICK_IMAGE_REQUEST = 71;
    private static final int ACTION_CODE = 1;
    private StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schoolregister);
        // Toast.makeText( getBaseContext(), "I was clicked", Toast.LENGTH_LONG ).show();
        //BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        school = (School) getIntent().getParcelableExtra("SchoolRegister");


        //assign the firebase auth instaances

        mAuth = FirebaseAuth.getInstance();

        mAuthListerner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                } else {
                    finish();
                    Intent intent = new Intent(SchoolRegisterView.this, StartActivity.class);
                    startActivity(intent);
                }
            }
        };


        //ASSIGN FIREBASE DATABASE INSTANCES
        storageReference = FirebaseStorage.getInstance().getReference();
        userDatabase = FirebaseDatabase.getInstance().getReference().child( "SchoolRegister" ).child(user.getUid() );

        // mDatabase = FirebaseDatabase.getInstance().getReference();

        //IMAGES
//        profilePic = (CircleImageView) findViewById(R.id.imageButton);
        //upload = (FloatingActionButton) findViewById( R.id.floatingActionButton );


        //ADDING  ID SaveData
        Button save = (Button) findViewById(R.id.saveData);
        // view = (Button) findViewById(R.id.view);

//        profilePic = (CircleImageView) findViewById(R.id.imageButton);
        //  profileImgPallete = (ImageView) findViewById(R.id.image_palette);

        year = (EditText) findViewById(R.id.year);
        schoolname = (EditText) findViewById(R.id.schoolname);
        schooladdress = (EditText) findViewById(R.id.schooladdress);
        schoolmanager = (EditText) findViewById(R.id.schoolmanager);
        contactdetails = (EditText) findViewById(R.id.contactdetails);
        emailaddress = (EditText) findViewById(R.id.emaladdress);


//        mDatabase = FirebaseDatabase.getInstance().getReference().child("SchoolRegister");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.getValue() != null) {
                    //ParentProfile parentProfile = dataSnapshot.getValue( ParentProfile.class );
                    School school = dataSnapshot.getValue(School.class);
                    year.setText(school.getYear());
                    schoolname.setText(school.getSchoolname());
                    schooladdress.setText(school.getSchooladdress());
                    schoolmanager.setText(school.getSchoolmanager());
                    contactdetails.setText(school.getContactdetails());
                    emailaddress.setText(school.getEmailaddress());
                    Toast.makeText(SchoolRegisterView.this, " Your..." + school.getEmailaddress(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}


