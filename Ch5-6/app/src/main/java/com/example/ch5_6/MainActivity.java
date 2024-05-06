package com.example.ch5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private TextView output;
    private float size = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        output.setTextSize(size); // 設置初始文字大小

        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size++; // 點擊按鈕時增加文字大小
                output.setTextSize(size);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size--; // 點擊按鈕時減小文字大小
                output.setTextSize(size);
            }
        });
    }
//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.button) {
//            size++;
//        }
//        else {
//            size--;
//        }
//        output.setTextSize(size);
//    }
}