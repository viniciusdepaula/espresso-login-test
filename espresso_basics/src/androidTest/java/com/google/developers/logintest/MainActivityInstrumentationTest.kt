package com.google.developers.logintest

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.util.Log
import com.example.ajeshpai.androidtesting.R
import org.junit.*


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentationTest {

    //rule is initialized
    //@Rule
    //@JvmField
    //val rule  = getRule()


    private val userName = "admin"
    private val correctPass = "admin"
    private val wrongPass = "admin1234"

    @Rule
    fun getRule(): ActivityTestRule<MainActivity> {
        Log.d("Inicializando a regra", "MainActivity")
        return ActivityTestRule(MainActivity::class.java)
    }


    companion object {

        @BeforeClass
        @JvmStatic
        fun before_class_method() {
            Log.d("@Before Class", "Será executado antes de todos testes")
        }

        @AfterClass
        @JvmStatic
        fun after_class_method() {
            Log.d("@After Class", "Será executado depois de todos dos testes")
        }

    }

    @Before
    fun before_test_method() {
        Log.d("@Before", "Isso será executado antes de cada um dos testes")
    }


    @Test
    fun login_success() {

        Espresso.onView((withId(R.id.user_name)))
                .perform(ViewActions.typeText(userName))

        Espresso.onView(withId(R.id.password))
                .perform(ViewActions.typeText(correctPass))

        Espresso.onView(withId(R.id.login_button))
                .perform(ViewActions.click())

        Espresso.onView(withId(R.id.login_result))
                .check(matches(withText(R.string.login_success)))

    }

    fun showingSucccess() {
        Espresso.onView(withId(R.id.login_result))
                .check(matches(withText(R.string.login_success)))
    }

    @Test
    fun login_failure() {
        Log.e("@Test", "Executando os testes de falha do login")
        Espresso.onView((withId(R.id.user_name)))
                .perform(ViewActions.typeText(userName))

        Espresso.onView(withId(R.id.password))
                .perform(ViewActions.typeText(wrongPass))

        Espresso.onView(withId(R.id.login_button))
                .perform(ViewActions.click())

        Espresso.onView(withId(R.id.login_result))
                .check(matches(withText(R.string.login_failed)))

    }

    @After
    fun after_test_method() {
        Log.d("@After", "Isso será executado depois de cada um dos testes")
    }

}