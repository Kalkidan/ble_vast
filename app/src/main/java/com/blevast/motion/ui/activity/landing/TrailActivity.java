package com.blevast.motion.ui.activity.landing;

import android.os.Bundle;

import com.blevast.motion.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TrailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_tool_bar_layout);
    }
}
