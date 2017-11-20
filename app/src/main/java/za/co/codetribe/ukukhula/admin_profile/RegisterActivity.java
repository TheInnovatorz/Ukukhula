package za.co.codetribe.ukukhula.admin_profile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import za.co.codetribe.ukukhula.MainActivity;
import za.co.codetribe.ukukhula.R;
import za.co.codetribe.ukukhula.User;


public class Register extends AppCompatActivity {


    Button registerButton;
    TextView text;
    EditText edtemail;
    EditText edtpassword;
    Spinner roles;

    RadioButton rb;
    Context context;


    private FirebaseAuth firebase;

    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser user;

    String roletpe;

    DatabaseReference mDatabase;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        finish();
        return super.onOptionsItemSelected(item);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // user = mAuth.getCurrentUser();

        progressDialog = new ProgressDialog(this);

        registerButton = (Button) findViewById(R.id.btnRegister);
        edtemail = (EditText) findViewById(R.id.edtEmail);
        edtpassword = (EditText) findViewById(R.id.edtPassword);
        roles = (Spinner) findViewById(R.id.roles);
        text = (TextView) findViewById(R.id.txtSign);
        firebase = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void save(View view) {

        registerUser();
        //popup dialogne3y
    }

    public void registerUser() {
        final String email = edtemail.getText().toString().trim();
        String password = edtpassword.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter your email  ", Toast.LENGTH_LONG).show();

            return;
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter your password  ", Toast.LENGTH_LONG).show();
            return;
        }
//        progressDialog.setMessage("Registering user......");
//        progressDialog.show();

        firebase.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();


                        if (task.isSuccessful()) {

                            String role = (String) roles.getSelectedItem();

                            User users = new User( "","",email,"","","","","",role);
                            Map<String, Object> parentProfileValues = users.toMap();
                            String userId = task.getResult().getUser().getUid();
                            Map<String, Object> childUpdates = new HashMap<>();
                            childUpdates.put("/users/" + userId, parentProfileValues);
                            mDatabase.updateChildren(childUpdates);

                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);

                            /*
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(OldRegister.this);
                            builder1.setMessage("Please update your personal details now or later?");
                            builder1.setCancelable(true);

                            builder1.setPositiveButton(
                                    "now",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                            Intent intent = new Intent(OldRegister.this, OldProfileActivity.class);
                                            startActivity(intent);

                                            // dialog.cancel();
                                        }
                                    });

                            builder1.setNegativeButton(
                                    "later",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {


                                            Intent intent = new Intent(OldRegister.this, MainActivity.class);
                                            startActivity(intent);

                                            //dialog.cancel();
                                        }
                                    });

                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                            */
                        } else {
                            Toast.makeText(getApplicationContext(), "User not successful registered...please try again ", Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }







}

