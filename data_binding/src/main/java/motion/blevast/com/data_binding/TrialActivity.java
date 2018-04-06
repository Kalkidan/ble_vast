package motion.blevast.com.data_binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import motion.blevast.com.data_binding.callback.TrialPageCallback;
import motion.blevast.com.data_binding.databinding.TrialPageBinding;
import motion.blevast.com.data_binding.model.TrialPageModel;

/**
 * TODO:: this is just a trial activity for data binding
 */

public class TrialActivity extends AppCompatActivity implements TrialPageCallback{


    TrialPageBinding trialPageBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the binding here.
        trialPageBinding = DataBindingUtil.setContentView(this, R.layout.trial_page);
        trialPageBinding.setTrialCallback(this);

        //Set on the model the things to be observed
        trialPageBinding.setTrialModel(new TrialPageModel());


    }

    /**
     * A call back from the xml
     */
    @Override
    public void onBackClicked(TrialPageModel trialPageModel) {

    }

    @Override
    public void onForwardClicked(TrialPageModel trialPageModel) {

    }
}
