package com.gu.task.androidmainifest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gu.task.R;
import com.gu.task.androidmainifest.singleinstance.SingleInstaceActivity;
import com.gu.task.androidmainifest.singletask.SingleTaskActivity;
import com.gu.task.androidmainifest.singletop.SingleTopActivity;
import com.gu.task.androidmainifest.standard.StandardModeActivity;
import com.gu.task.base.BaseActivity;

/**
 * Created by Nate on 2016/1/11.AndroidMainifest 主界面
 */
public class MainifestMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfest);
        findViewById(R.id.standard_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainifestMainActivity.this, StandardModeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.singletop_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainifestMainActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.singletask_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainifestMainActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.singleinstance_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainifestMainActivity.this, SingleInstaceActivity.class);
                startActivity(intent);
            }
        });
    }
}
