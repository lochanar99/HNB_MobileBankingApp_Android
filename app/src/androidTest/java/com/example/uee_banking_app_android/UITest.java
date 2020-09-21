package com.example.uee_banking_app_android;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import static android.os.SystemClock.sleep;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UITest {

    private boolean logoutWhenDone = false;

    @BeforeClass
    public static void beforeClass()
    {
        MainActivity.autoFill = false;
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void loginTest() {
        // Type text and then press the button.

        runAction(R.id.username)
                .perform(typeText("John Doe"));
        runAction(R.id.password)
                .perform(typeText("thanos"), closeSoftKeyboard());
       runAction(R.id.button).perform(click());
        runAction(R.id.smsCode)
                .perform(typeText("628682"),closeSoftKeyboard());
        runAction(R.id.submit).perform(click());
        if(logoutWhenDone)
        {
            runAction(R.id.ok).perform(click());
        }
        sleep(2000);
    }

    @Test
    public void forgotPasswordTest()
    {
        runAction(R.id.forgotPassword).perform(click());
        runAction(R.id.forgotPWusername)
                .perform(typeText("John Doe"), closeSoftKeyboard());
        runAction(R.id.button).perform(click());
        runAction(R.id.submit).perform(click());
        sleep(1000);
    }

    @Test
    public void register()
    {
        runAction(R.id.Register).perform(click());
        runAction(R.id.username)
                .perform(typeText("John Doe\n"));
        runAction(R.id.password)
                .perform(typeText("0713659825\n"));
        runAction(R.id.creditCardNo)
                .perform(typeText("3251 2532 9215\n"));
        runAction(R.id.emailSwitch)
                .perform(typeText("jDoe@gmail.com\n"));
        runAction(R.id.NIC)
                .perform(typeText("961341284V"),closeSoftKeyboard());

        runAction(R.id.button).perform(click());
        runAction(R.id.ok).perform(click());
        sleep(1000);
    }

    @Test
    public void mails()
    {
        logoutWhenDone = false;
        loginTest();
        runAction(R.id.mailText).perform(click());
        runAction(R.id.button5).perform(click());
        runAction(R.id.constraint).perform(click());
        runAction(R.id.button).perform(click());

        runAction(R.id.creditCardNo)
                .perform(typeText("Deactivate Card"),closeSoftKeyboard());
        runAction(R.id.emailSwitch)
                .perform(typeText("Hi, \n\nI would like to know how to deactivate web service for a credit card"), closeSoftKeyboard());

        runAction(R.id.button).perform(click());
        runAction(R.id.submit).perform(click());
        runAction(R.id.button6).perform(click());
        runAction(R.id.ok).perform(click());

        logoutWhenDone = true;
        sleep(1000);
    }







    public static ViewInteraction runAction(int id)
    {
        sleep(600);
        return onView((withId(id)));
    }




}
