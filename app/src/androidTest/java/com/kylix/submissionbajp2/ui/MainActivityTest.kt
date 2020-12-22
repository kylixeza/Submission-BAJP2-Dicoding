package com.kylix.submissionbajp2.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.kylix.submissionbajp2.R
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.ui.activities.MainActivity
import com.kylix.submissionbajp2.util.EspressoIdlingResource
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


class MainActivityTest {

        @Rule
        @JvmField
        var activityRule = ActivityTestRule(MainActivity::class.java, true)

        @Before
        fun setUp() {
            IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource())
        }

        @After
        fun tearDown() {
            IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource())
        }

        @Test
        fun loadMovie() {
            onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
            onView(withId(R.id.nav_movie)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_movie)).apply {
                check(matches(isDisplayed()))
                perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
            }
        }

        @Test
        fun movieBehaviour() {
            onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
            onView(withId(R.id.nav_movie)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_movie)).apply {
                perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
                pressBack()
                check(matches(isDisplayed()))
                perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(19, click()))
                pressBack()
            }
        }
}