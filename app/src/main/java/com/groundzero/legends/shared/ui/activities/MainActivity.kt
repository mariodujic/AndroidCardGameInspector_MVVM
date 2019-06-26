package com.groundzero.legends.shared.ui.activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.groundzero.legends.R
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigation()
    }

    private fun setNavigation() {
        val navController = findNavController(R.id.card_fragment_container)
        setupActionBarWithNavController(navController, getAppBarConfiguration())
        bottom_navigation.setupWithNavController(navController)
        bottom_navigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
    }

    private fun getAppBarConfiguration(): AppBarConfiguration {
        return AppBarConfiguration
            .Builder(R.id.decksFragment, R.id.allCardsFragment)
            .build()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun setToolbar(activity: Activity, title: String): ActionBar {
        val actionBar: ActionBar = (activity as AppCompatActivity).supportActionBar!!
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar.customView = titleView(activity, title)
        return actionBar
    }

    private fun titleView(activity: Activity, title: String): TextView {
        val toolbarTitle: TextView = LayoutInflater.from(activity).inflate(R.layout.toolbar_title, null) as TextView
        toolbarTitle.text = title
        return toolbarTitle
    }
}
