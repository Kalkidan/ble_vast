package com.blevast.motion;

import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
