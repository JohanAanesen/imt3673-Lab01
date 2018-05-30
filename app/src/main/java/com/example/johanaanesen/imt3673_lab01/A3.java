package com.example.johanaanesen.imt3673_lab01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class A3 extends AppCompatActivity {

    static final String T4_TEXT = "T4-text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
    }

    public void goToA2(View view) {
        EditText editText = findViewById(R.id.T4);
        String text = editText.getText().toString();

        Intent intent = new Intent(this, A2.class);
        intent.putExtra(T4_TEXT, text);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        EditText editText = findViewById(R.id.T4);
        String text = editText.getText().toString();

        if (text.equals("")){
            text = " ";
        }

        Intent intent = new Intent(this, A2.class);
        intent.putExtra(T4_TEXT, text);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
