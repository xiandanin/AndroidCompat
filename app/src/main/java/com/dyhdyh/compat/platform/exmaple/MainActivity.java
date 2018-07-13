package com.dyhdyh.compat.platform.exmaple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dyhdyh.compat.platform.EnvironmentCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StringBuffer sb = new StringBuffer();
        sb.append("相机目录:\n");
        sb.append(EnvironmentCompat.getCameraDirectory(this));

        TextView tv = findViewById(R.id.tv);
        tv.setText(sb);
    }
}
