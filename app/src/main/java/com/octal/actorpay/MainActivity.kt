package com.octal.actorpay

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.octal.actorpay.base.BaseActivity
import com.octal.actorpay.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Data binding here
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_Container) as NavHostFragment).navController

    }


    override fun onSupportNavigateUp(): Boolean {
        if (navController!!.navigateUp() == false) {
            onBackPressed()
        }
        return navController!!.navigateUp()
    }
    override fun onBackPressed() {
        when (navController!!.currentDestination?.id) {
            R.id.homeFragment -> {
                navController!!.navigateUp()
            }
            R.id.walletFragment -> {
                navController!!.navigateUp()
            }
            else -> super.onBackPressed()
        }
        // super.onBackPressed()
    }

/*

    override fun onBackPressed() {
        when (navController!!.currentDestination?.id) {
            R.id.homeFragment -> {
                navController!!.navigateUp()
            }
            else -> super.onBackPressed()
        }
        super.onBackPressed()
    }
*/

    /* override fun onBackPressed() {
         *//* when (navController!!.currentDestination?.id) {
             R.id.homeFragment -> {
                 navController!!.navigateUp()
             }
             else -> super.onBackPressed()
         }*//*
        if (navController!!.currentDestination == null || navController!!.currentDestination!!.id == R.id.homeFragment) {
            navController?.navigate(R.id.homeFragment)
        } else
            super.onBackPressed()
    }*/


}