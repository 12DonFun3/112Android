package com.example.temptransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  button_Click(View view){
        EditText edtTemp = (EditText) findViewById(R.id.edt_Temp);
        TextView txvshow = (TextView) findViewById(R.id.txv_show);

        double degreeC = Integer.parseInt(edtTemp.getText().toString());
        double degreeF = (9.0 * degreeC) / 5.0 + 32.0;

        txvshow.setText("華氏溫度" + String.format("%.2f",degreeF) + "℉");

    }
}