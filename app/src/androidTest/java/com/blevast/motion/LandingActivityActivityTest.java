package com.blevast.motion;

import android.net.LinkAddress;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by kaltadesse on 4/10/18.
 */


@RunWith(AndroidJUnit4.class)
public class LandingActivityActivityTest {

    @Rule
    public ActivityTestRule<LandingActivity> landingActivityActivityTestRule = new ActivityTestRule<>(LandingActivity.class);

    @Before
    public void setup(){
        Intents.init();
    }

    @After
    public void tearDown(){
        Intents.release();
    }

    @Test
    public void is_app_running(){
        //(landingActivityActivityTestRule.getActivity()).runVastProcessor();
        onView(withId(R.id.redirect_url)).check(matches(not(withText(""))));


        //use Junit to test the pay  load
    }
}
