package com.example.johanaanesen.imt3673_lab01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class A2 extends AppCompatActivity {

    static final String T1_TEXT = "T1-text";
    static final String T4_TEXT = "T4-text";

    private String textFromA1;
    private String textFromA3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        //Get text from A1
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            textFromA1 = extras.getString(T1_TEXT);
        }

        if (textFromA1 != ""){
            final TextView T2 = findViewById(R.id.T2);
            T2.setText("Hello " + this.textFromA1);
        }
    }

    public void goToA3(View view) {
        Intent intent = new Intent(this, A3.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                //Get text from A3
                textFromA3 = data.getStringExtra(T4_TEXT);

                final TextView T3 = findViewById(R.id.T3);
                T3.setText("From A3: " + this.textFromA3);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Handle error?
            }
        }
    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, A1.class);
        startActivity(intent);
    }
}
