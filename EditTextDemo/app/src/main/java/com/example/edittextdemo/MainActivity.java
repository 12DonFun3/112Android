package com.example.edittextdemo;

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
    public void button_Click(View view){
        EditText edt_name = (EditText) findViewById(R.id.edt_name);
        TextView txv_show = (TextView) findViewById(R.id.txv_show);
        String name = edt_name.getText().toString();
        txv_show.setText("你的名字是:" + name);
    }

}

