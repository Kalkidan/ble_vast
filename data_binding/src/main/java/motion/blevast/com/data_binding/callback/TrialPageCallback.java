package motion.blevast.com.data_binding.callback;

import motion.blevast.com.data_binding.model.TrialPageModel;

/**
 * A trial page call back
 */

public interface TrialPageCallback {

    void onBackClicked(TrialPageModel trialPageModel);
    void onForwardClicked(TrialPageModel trialPageModel);
}
