package za.co.codetribe.ukukhula.learner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

import za.co.codetribe.ukukhula.AdminProfile.Register;
import za.co.codetribe.ukukhula.R;


public class LearnrsActivity extends AppCompatActivity {
    FirebaseDatabase firebaseData;
    DatabaseReference roofdef, demodef;
    ListView listview;
    LearnersAdapter adapter;
    List<LearnerProfile> profLists;
    Context context;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, RegisterLearner.class);
                startActivity(intent);
                return true;
//
//            finish();
            default:
            return super.onOptionsItemSelected(item);

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilekid);
        context = getBaseContext();


        user = FirebaseAuth.getInstance().getCurrentUser();

        Log.i(" mlab",user.getUid());

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listview = (ListView) findViewById(R.id.listView);
        // save = (Button) findViewById(R.id.save);

        profLists = new ArrayList<>();

        roofdef = FirebaseDatabase.getInstance().getReference();
        demodef = roofdef.child("Children").child(user.getUid());

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LearnerProfile testData =  profLists.get(i);
                Log.i(" Dimplez ", testData.getNames() + testData.getNames()+ testData.getSurname() );

                Intent intent=new Intent(LearnrsActivity.this, ViewLearnerActivity.class);
                intent.putExtra("data",testData);
                startActivity(intent);
                Toast.makeText(context, "I'm inside the list " , Toast.LENGTH_LONG).show();


            }
        });


    }

    //fetch
//
    @Override
    protected void onStart() {
        super.onStart();
        demodef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                profLists = new ArrayList<>();
                Log.i(" f=====================", dataSnapshot.toString());

                for (DataSnapshot profilesShot : dataSnapshot.getChildren()) {
                    Log.i(" AVIWE ", profilesShot.toString());
                    LearnerProfile profil = profilesShot.getValue(LearnerProfile.class);
                    profLists.add(profil);

                }

                adapter = new LearnersAdapter(getBaseContext(), profLists);
                listview.setAdapter(adapter);
                //adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learners, menu);

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    //int id = item.getItemId();
//
//        switch (item.getItemId()) {
//            case R.id.Reg:
//                Intent intent = new Intent(this, RegisterLearners.class);
//                startActivity(intent);
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
