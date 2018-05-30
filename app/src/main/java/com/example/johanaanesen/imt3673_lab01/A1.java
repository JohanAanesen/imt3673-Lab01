package com.example.johanaanesen.imt3673_lab01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class A1 extends AppCompatActivity {
    static final String SPINNER_CHOICE = "spinner-choice";
    static final String T1_TEXT = "T1-text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        spinnerSelect();
    }

    public void goToA2(View view) {

        EditText editText = findViewById(R.id.T1);
        String text = editText.getText().toString();

        if (text.equals("")){
            text = " ";
        }

        Intent intent = new Intent(this, A2.class);
        intent.putExtra(T1_TEXT, text);
        startActivity(intent);
    }

    private void spinnerSelect(){

        //spinner
        final Spinner spinner =  findViewById(R.id.L1);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.L1_values,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Get spinner shared state
        final SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        final int userChoice = shared.getInt(SPINNER_CHOICE, -1);

        if (userChoice == -1) {
            //Error?
        } else {
            spinner.setSelection(userChoice);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {


                Object item = adapterView.getItemAtPosition(position);
                if (item != null)
                {
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putInt(SPINNER_CHOICE, position); // Storing integer
                    editor.apply(); // commit changes

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                //Error?
            }
        });
    }




    @Override
    public void onBackPressed(){ // https://stackoverflow.com/a/42615612 answer i've used :)
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
