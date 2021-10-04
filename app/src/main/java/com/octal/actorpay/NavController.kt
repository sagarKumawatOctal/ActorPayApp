package com.octal.actorpay

import androidx.navigation.NavController
import androidx.navigation.NavOptions

class NavController {
    fun navigateWithId(id: Int, navigationController: NavController) {
        navigationController.navigate(id)
    }
}