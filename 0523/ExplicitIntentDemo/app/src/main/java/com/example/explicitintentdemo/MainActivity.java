package com.example.explicitintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTransf = (Button) findViewById(R.id.btnTransf);
        btnTransf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtC = (EditText) findViewById(R.id.txtc);
                int tempC = Integer.parseInt(txtC.getText().toString());
                EditText edtPlace = (EditText) findViewById(R.id.edtPlace);
                Intent intent = new Intent(MainActivity.this, FActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("TEMPC", tempC);
                bundle.putString("Place", edtPlace.getText().toString());
                intent.putExtras(bundle);
                startActivities(intent);
            }

            private void startActivities(Intent intent) {

            }
        });
    }
}