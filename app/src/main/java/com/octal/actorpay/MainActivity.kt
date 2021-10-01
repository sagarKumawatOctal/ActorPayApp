package com.octal.actorpay

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.octal.actorpay.base.BaseActivity
import com.octal.actorpay.ui.dashboard.bottomnavfragments.HomeBottomFragment

class MainActivity : BaseActivity() {
    val navController: NavController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Data binding here
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /**
         * initialize the view-model
         */
        setContentView(R.layout.activity_main)
        //initiliation()

    }

    override fun onBackPressed() {
        val fragments = supportFragmentManager.fragments
        if(fragments.size > 0) {
            supportFragmentManager.popBackStack()

        } else {

            super.onBackPressed()
        }


       /* if(Navigation.popBackStack().not()) {
            //Last fragment: Do your operation here
            finish()*/



    }

}