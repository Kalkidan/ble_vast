package com.blevast.motion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import motion.blevast.parser.vastad.model.VastData;

import static com.blevast.motion.LandingActivity.EXTRA_VAST_LOAD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<VastData> vastData = null;
        if(getIntent() != null){
            //Get the list of vast data.
            vastData = (List<VastData>) getIntent().getSerializableExtra(EXTRA_VAST_LOAD);

            if(vastData.isEmpty()){}
        }
        setContentView(R.layout.activity_main);
    }
}
