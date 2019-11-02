package com.example.unittesting;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    private String dummyVolume = "504.0";
    private static final String dummyCircumference = "2016.0";
    private String dummySurfaceArea = "396.0";
    private String dummyLength = "12.0";
    private String dummyWidth = "7.0";
    private String dummyheight = "6.0";
    private String emptyInput = "";
    private String fieldEmpty = "Field ini tidak boleh kosong";
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void getCircumference() {
        // set value from edittext
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyheight), closeSoftKeyboard());

        //set click save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        // set click calculate circumferece
        onView(withId(R.id.btn_calculate_circumference)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_circumference)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyCircumference)));
    }

    @Test
    public void getVolume(){
        onView(withId(R.id.edt_height)).perform(typeText(dummyheight), closeSoftKeyboard());
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_calculate_volume)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_volume)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyVolume)));

    }

    @Test
    public void emptyInput(){
        // ketika width kosong
        onView(withId(R.id.edt_width)).perform(typeText(emptyInput), closeSoftKeyboard());
        // klik button save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        // response error dari width ketika kosong
        onView(withId(R.id.edt_width)).check(matches(hasErrorText(fieldEmpty)));
        // ketika width tidak kosong
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        // ketika length berisi kosong
        onView(withId(R.id.edt_length)).perform(typeText(emptyInput), closeSoftKeyboard());
        // ketika button save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        // menampilan erorr
        onView(withId(R.id.edt_length)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        // menginputkan nilai kosong
        onView(withId(R.id.edt_height)).perform(typeText(emptyInput), closeSoftKeyboard());
        // menginputkan button save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        // menampilkan error
        onView(withId(R.id.edt_height)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edt_height)).perform(typeText(dummyheight), closeSoftKeyboard());
        // response click button save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

    }


}