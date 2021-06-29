package com.ddory.hoya.biblereader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.ddory.hoya.biblereader.ui.ActivityViewModel
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private val viewModel: ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_page_home -> viewModel.navigationEvent(ActivityViewModel.NavEvent.HOME)
                R.id.action_page_friends -> viewModel.navigationEvent(ActivityViewModel.NavEvent.FRIENDS)
                R.id.action_page_settings -> viewModel.navigationEvent(ActivityViewModel.NavEvent.SETTINGS)
            }
            true
        }
    }

    fun enableBottomNavigation(isEnable: Boolean) {
        bottom_navigation.visibility = if (isEnable) View.VISIBLE else View.GONE
    }
}
