package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox original, beef, seafood;
    private TextView output; // Declare output as a class-level variable

    private int[] chkIDs = {R.id.chkOriginal, R.id.chkBeef, R.id.chkSeafood};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        original = findViewById(R.id.chkOriginal);
        beef = findViewById(R.id.chkBeef);
        seafood = findViewById(R.id.chkSeafood);


        output = findViewById(R.id.lblOutput); // Initialize output
        Button btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                if (original.isChecked()) {
                    str += original.getText() + "\n";
                }

                if (beef.isChecked()) {
                    str += beef.getText() + "\n";
                }

                if (seafood.isChecked()) {
                    str += seafood.getText() + "\n";
                }

                output.setText(str);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String str = ""; // Initialize the string variable
        for (int id : chkIDs) { // Loop through all CheckBox IDs
            CheckBox chk = findViewById(id);
            if (chk.isChecked()) { // Check if the CheckBox is checked
                str += chk.getText() + "\n"; // Append the text of the checked CheckBox
            }
        }
        output.setText(str); // Set the text in the output TextView
    }

//        if (id == R.id.chkOriginal) {
//            output.setText("你點選的是原味...\n");
//        } else if (id == R.id.chkBeef) {
//            output.setText("你點選的是牛肉...\n");
//        } else if (id == R.id.chkSeafood) {
//            output.setText("你點選的是海鮮...\n");
//        }
}