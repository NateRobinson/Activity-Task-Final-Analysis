package com.gu.task.androidmainifest.singletop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gu.task.R;
import com.gu.task.base.BaseActivity;

/**
 * Created by Nate on 2016/1/11.
 */
public class SingleTopActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletop);
        findViewById(R.id.new_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTopActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });
    }


}
