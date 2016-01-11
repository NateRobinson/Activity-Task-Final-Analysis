package com.gu.task.androidmainifest.singletask;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gu.task.R;
import com.gu.task.base.BaseActivity;

/**
 * Created by Nate on 2016/1/11.
 */
public class SingleTaskActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletask);
        findViewById(R.id.new_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("nate","SingleTaskActivity===>onNewIntent");
    }
}
