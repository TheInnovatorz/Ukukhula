package za.co.codetribe.ukukhula.Groups;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import za.co.codetribe.ukukhula.R;
import za.co.codetribe.ukukhula.gallery.GallaryActivity;
import za.co.codetribe.ukukhula.gallery.ImageAdapter;
import za.co.codetribe.ukukhula.gallery.ImagePojo;
import za.co.codetribe.ukukhula.gallery.ViewImageActivity;
import za.co.codetribe.ukukhula.learner.LearnerProfile;
import za.co.codetribe.ukukhula.learner.LearnersAdapter;

public class RegistedKidsActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    List<LearnerProfile> kidslist;
    ListView listView;
    LearnerProfile learnerProfile;
    ProgressDialog pd;

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        finish();
//        return super.onOptionsItemSelected(item);
//
//    }
Group object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_groups);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        object = (Group) getIntent().getParcelableExtra("groups");



        TextView grpname=(TextView) findViewById(R.id.groupname);

        grpname.setText(object.getGroupNane());



        listView = (ListView) findViewById(R.id.listgroup);

        kidslist = new ArrayList<>();

        pd = new ProgressDialog(this);
        pd.setMessage(" please wait ....");
        pd.show();

        databaseReference = FirebaseDatabase.getInstance().getReference("RegistedChildren");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pd.dismiss();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Log.i(" AVIWE", dataSnapshot.toString());
                    learnerProfile = dataSnapshot1.getValue(LearnerProfile.class);
                    kidslist.add(learnerProfile);

                    Log.i(" REGISTER", dataSnapshot.toString());


                }


                RegisteredLearnersAdapter adapter = new RegisteredLearnersAdapter(RegistedKidsActivity.this, R.layout.registeslearnerslist, kidslist);


                listView.setAdapter(adapter);
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                        Intent intent =new Intent(RegistedKidsActivity.this,ViewImageActivity.class);
//                        intent.putExtra("imagePojo",learnerProfile);
//                        startActivity(intent);
//                        //Toast.makeText(RegistedKidsActivity.this, learnerProfile.getUrl(), Toast.LENGTH_LONG).show();
//                    }
//                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                pd.dismiss();

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId() )
        {
            case R.id.add:
                Intent intent = new Intent(RegistedKidsActivity.this,GallaryActivity.class);
                startActivity(intent);

        }
        finish();
        return super.onOptionsItemSelected(item);
    }

    //menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learners, menu);
        return true;
    }

}
