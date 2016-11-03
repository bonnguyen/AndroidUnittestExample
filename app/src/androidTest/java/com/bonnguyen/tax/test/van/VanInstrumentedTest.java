package com.bonnguyen.tax.test.van;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bonnguyen.tax.test.MainActivity;
import com.bonnguyen.tax.test.R;
import com.squareup.spoon.Spoon;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by nguyenbon on 10/28/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class VanInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);
    private MainActivity mainActivity;

    @Before
    public void setActivity() {
        mainActivity = mActivityRule.getActivity();
    }

    @Test
    public void testCalculatorTax() throws Exception {
        Spoon.screenshot(mainActivity, "initial_state");
        String value = "3000";
        String result = "165";

        Matcher viewMatcherEdtValue = withId(R.id.edt_value);
        ViewAction viewActionEdtValue = typeText(value);
        onView(allOf(viewMatcherEdtValue, withHint("Enter weight"))).perform(viewActionEdtValue);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        Matcher viewMatcherBtnCalc = withId(R.id.btn_calc);
        onView(allOf(viewMatcherBtnCalc, withHint("Calc Tax Van"))).perform(click());
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        Matcher viewMatcherTvResult = withId(R.id.tv_result);
        Matcher matcherResult = withText(result);
        ViewAssertion viewAssertionTvResult = matches(matcherResult);
        onView(allOf(viewMatcherTvResult, withHint("Tax result van"))).check(viewAssertionTvResult);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        Spoon.screenshot(mainActivity, "after_state");
    }
}
