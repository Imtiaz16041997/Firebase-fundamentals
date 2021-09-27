package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2,t3,t4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        b1 = findViewById(R.id.b1);

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference root = db.getReference("students");




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String roll  = t1.getText().toString().trim();
                String name  = t2.getText().toString().trim();
                String course  = t3.getText().toString().trim();
                String duration  = t4.getText().toString().trim();

                //create dataHolder object
                dataHolder object = new dataHolder(name,course,duration);

                root.child(roll).setValue(object);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");

//                root.setValue(t1.getText().toString());
//                t1.setText("");
                Toast.makeText(getApplicationContext(),"Multiple Data Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}