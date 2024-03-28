package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{
    private TextView txvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = (TextView) findViewById(R.id.txvShow) ;
        txvShow.setTextSize(36);
        EditText edtH = (EditText) findViewById(R.id.edtH);
        EditText edtW = (EditText) findViewById(R.id.edtW);
        Button btnCal = (Button) findViewById(R.id.btnCal);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(edtH.getText().toString());
                double weight = Double.parseDouble(edtW.getText().toString());
                double bmi = weight/ Math.pow(height/100.0, 2); //身高換算公尺再平方
                if (bmi >=24)
                    txvShow.setTextColor(Color.RED);
                else if (bmi<18.5)
                    txvShow.setTextColor(Color.BLUE);
                else
                    txvShow.setTextColor(Color.GREEN);

                txvShow.setText(String.format("%.2f", bmi));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtH.setText("0");
                edtW.setText("0");
                txvShow.setText("");
            }
        });
    }
//    @Override
//    public void onClick(View v) {
//    EditText edtH = (EditText) findViewById(R.id.edtH);
//    EditText edtW = (EditText) findViewById(R.id.edtW);
//
//    if(v.getId() == R.id.btnCal){
//        double height = Double.parseDouble(edtH.getText().toString());
//        double weight = Double.parseDouble(edtW.getText().toString());
//        double bmi = weight/ Math.pow(height/100.0, 2); //身高換算公尺再平方
//        if (bmi >=24)
//            txvShow.setTextColor(Color.RED);
//        else if (bmi<18.5)
//            txvShow.setTextColor(Color.BLUE);
//        else
//            txvShow.setTextColor(Color.GREEN);
//
//        txvShow.setText(String.format("%.2f", bmi));
//    }else{
//        edtH.setText("0");
//        edtW.setText("0");
//        txvShow.setText("");
//        }
//    }

}