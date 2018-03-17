package com.fjnu.sir.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显式 Intent 启动 SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //因为 SecondActivity 做了接收数据处理，所以这里加上 putExtra
                String data = "Hello SecondActivity";
                intent.putExtra("extra_data", data);

                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //隐式 Intent 启动 ThirdActivity
                Intent intent = new Intent("com.example.activitytest.ACTION_START");

                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //隐式 Intent 启动 ThirdActivity
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过 intent 向下一个活动传递数据
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String data = "Hello SecondActivity";
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过 intent 向上一个活动传递数据
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String data = "Hello SecondActivity";
                intent.putExtra("extra_data", data);
                startActivityForResult(intent,1);
            }
        });
    }
}
