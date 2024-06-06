package com.example.explictinteldemo2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;

    // 创建一个ActivityResultLauncher，用于启动OpActivity并处理返回结果
    ActivityResultLauncher<Boolean> launcher = registerForActivityResult(new ResultContract(),
            new ActivityResultCallback<String>() {
                @Override
                public void onActivityResult(String result) {
                    // 处理从OpActivity返回的结果，并更新TextView
                    output.setText("計算結果:" + result);//1
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取TextView用于显示结果
        output = findViewById(R.id.lblOutput);

        // 设置按钮的点击监听器
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动OpActivity
                launcher.launch(true);
            }
        });
    }

    // 定义ResultContract类，用于处理Activity之间的数据传递
    class ResultContract extends ActivityResultContract<Boolean, String> {

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean input) {//收完ResultContract()資料回來啟動
            // 创建启动OpActivity的Intent，并传递操作数
            Intent intent = new Intent(MainActivity.this, OpActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01", ((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            bundle.putString("OPERAND02", ((EditText) findViewById(R.id.txtOpd2)).getText().toString());
            intent.putExtras(bundle);
            return intent;
        }

        @Override
        public String parseResult(int resultCode, @NonNull Intent intent) {
            // 解析OpActivity返回的结果，并将其转换为String类型
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result.toString(); //1
        }
    }

}
