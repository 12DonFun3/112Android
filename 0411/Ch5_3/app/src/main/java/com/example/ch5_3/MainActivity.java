package com.example.ch5_3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ch5_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private float original_size = 20;
    private TextView txvOutput;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 設置活動的佈局

        // 找到 TextView 元件並設置初始文字大小
        TextView txvOutput = (TextView) findViewById(R.id.txvOutput);
        txvOutput.setTextSize(TypedValue.COMPLEX_UNIT_PX, original_size);

        // 找到按鈕元件並設置點擊和長按事件監聽器
        Button btnEnlarge = (Button) findViewById(R.id.btnEnlarge);
        btnEnlarge.setOnClickListener(this);
        btnEnlarge.setOnLongClickListener(this);
    }

    // 點擊事件處理方法
    @Override
    public void onClick(View v) {
        TextView txvOutput = (TextView) findViewById(R.id.txvOutput);
        float size = txvOutput.getTextSize(); // 獲取當前文字大小
        Log.v("SIZE", "size = " + size); // 記錄日誌：輸出文字大小
        txvOutput.setTextSize(px2sp(this, size) + 5); // 將文字大小增加 1 個單位
    }

    // 長按事件處理方法
    @Override
    public boolean onLongClick(View v) {
        TextView txvOutput = (TextView) findViewById(R.id.txvOutput);
        txvOutput.setTextSize(original_size); // 將文字大小設置為原始大小
        return false;
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
}
