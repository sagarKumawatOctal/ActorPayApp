package com.octal.actorpay

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.octal.actorpay.base.BaseActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : BaseActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Data binding here
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /**
         * initialize the view-model
         */
        setContentView(R.layout.activity_main)
    }


//    override fun onBackPressed() {
//        super.onBackPressed()
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        val fragment : View? = findViewById(R.id.nav_host_fragment_content_main)
//
//        val currentFragment: Fragment =
//            fragment.getChildFragmentManager().getFragments().get(0)
//        if (currentFragment is OnBackPressedListener) (currentFragment as OnBackPressedListener).onBackPressed() else if (!navController.popBackStack()) finish()
//    }


}