package com.gu.task.androidmainifest.singleinstance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gu.task.R;
import com.gu.task.androidmainifest.singletask.NormalActivity;
import com.gu.task.base.BaseActivity;

/**
 * Created by Nate on 2016/1/11.
 */
public class SingleInstaceActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstace);
        findViewById(R.id.new_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstaceActivity.this, SingleInstaceActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("nate", "SingleTaskActivity===>onNewIntent");
    }
}
