package com.groundzero.legends

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.groundzero.legends.ui.shared.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardsFragmentTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun cardsFragmentTitle_shouldReturnTrue() {
        onView(withId(R.id.title_view))
            .check(matches(withText(rule.activity.resources.getString(R.string.cards_fragment_title))))
    }
}
