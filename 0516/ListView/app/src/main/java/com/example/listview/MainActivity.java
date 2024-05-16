package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = getResources().getStringArray(R.array.cities);
        lv = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adpCities = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cities);

        // 将适配器设置到ListView上
        lv.setAdapter(adpCities);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 使用参数parent获取所选项目
                String selectedCity = parent.getItemAtPosition(position).toString();
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText("你是住在" + selectedCity);
                Toast.makeText(MainActivity.this, "你是住在" + cities[position],
                        Toast.LENGTH_SHORT).show(); //出現時間
            }
        });
    }
}