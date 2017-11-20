package za.co.codetribe.ukukhula.Groups;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import za.co.codetribe.ukukhula.R;
import za.co.codetribe.ukukhula.notifications.EventActivity;
import za.co.codetribe.ukukhula.notifications.Eventhelper;

import static android.app.DatePickerDialog.OnDateSetListener;
import static za.co.codetribe.ukukhula.R.id.gName;



public class ClassesActivitysList extends AppCompatActivity {

    EditText grpName, grpTeacher;
    String eName, eTeacher;

    Button save;
    Boolean val = true;
    private static final String TAG = " HJHJKHJJH";

    FloatingActionButton add;
    FirebaseDatabase firebaseData;
    DatabaseReference roofdef, demodef;
    ListView listview;
    List<Group> groupList;

    DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;

    private OnDateSetListener mDateSetListener;


    //ProfileActivityhelpers helper;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        save = (Button) findViewById(R.id.saveData);
        grpName = (EditText) findViewById(gName);
        grpTeacher = (EditText) findViewById(R.id.gTeachers);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("Group");

        groupList = new ArrayList<>();
        listview = (ListView) findViewById(R.id.listView);


//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addEvent();
//            }
//        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Group testData =  groupList.get(i);
                Log.i(" Dimplezzzzz ", testData.getGroupNane() + testData.getGroupTeacher());

                Intent intent=new Intent(ClassesActivitysList.this, RegistedKidsActivity.class);
                intent.putExtra("groups",testData);
                startActivity(intent);
                //Toast.makeText(context, "I'm inside the list " , Toast.LENGTH_LONG).show();


            }
        });

        add = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ClassesActivitysList.this, ClassesActivitys.class);
                startActivity(intent);
            }
        });
    }


//    private void addGroup() {
//        Group group = new Group();
//        eName = grpName.getText().toString().trim();
//        eTeacher = grpTeacher.getText().toString().trim();

//
////        if (!TextUtils.isEmpty(eName)) {
////            event.setEventName(eName);
//
//
////        } else {
////            Toast.makeText(ClassesActivitys.this, "Event not saved ", Toast.LENGTH_LONG).show();
////        }
//
//
////        if (!TextUtils.isEmpty(eDescription)) {
////            event.setEventDiscription(eDescription);
////
////
////        } else {
////            Toast.makeText(ClassesActivitys.this, "no desc", Toast.LENGTH_LONG).show();
////        }
////
////
////        if (!TextUtils.isEmpty(eDate)) {
////            event.setDate(eDate);
////
////
////        } else {
////            Toast.makeText(ClassesActivitys.this, "NO DATE", Toast.LENGTH_LONG).show();
////        }
//
//
//        Group groups = new Group(eName, eTeacher);
//        mDatabase.push().setValue(groups);
//
//        grpName.setText(" ");
//        grpTeacher.setText(" ");
//
//
//        try {
//
//
//        } catch (Exception e) {
//            val = false;
//        } finally {
//            if (val) {
//                Toast.makeText(ClassesActivitysList.this, "group saved ", Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(ClassesActivitysList.this, "group not saved ", Toast.LENGTH_LONG).show();
//            }
//        }




    //fetch

    @Override
    protected void onStart() {
        super.onStart();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                groupList.clear();

                Log.i(" f=====================", dataSnapshot.toString());

                for (DataSnapshot eventsShot : dataSnapshot.getChildren()) {
                    Log.i(" AVIWE", eventsShot.toString());
                    Group group = eventsShot.getValue(Group.class);
                    groupList.add(group);

                }

                GroupAdapter adapter = new GroupAdapter(ClassesActivitysList.this, groupList);
                listview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
//    public void showUpdateDIALOG(String id, String eventName, String eventDescription) {
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = getLayoutInflater();
//
//        final View dialogView = inflater.inflate(R.layout.dialog, null);
//        dialogBuilder.setView(dialogView);
//
//        final EditText Ename = (EditText) dialogView.findViewById(R.id.eventName);
//        final EditText Edescription = (EditText) dialogView.findViewById(R.id.eventDescription);
//        final Button update = (Button) dialogView.findViewById(R.id.update);
//
//        dialogBuilder.setTitle("Update Event" + id);
//
//        AlertDialog alertDialog = dialogBuilder.create();
//        alertDialog.show();
//
//
//    }









