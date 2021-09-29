package com.octal.actorpay.app

import android.content.Context
import androidx.multidex.MultiDexApplication

/**
 * MyApplication
 * @author Imran Khan
 * @version 1.0
 * @since 1.0
 */


class MyApplication : MultiDexApplication() {

    /**
     * companion object
     */
    companion object {
        // Firebase setUp
        /*   var mUserDatabase: DatabaseReference? = null
           var mFirebaseAuth: FirebaseAuth? = null
           var mUser: FirebaseUser? = null*/

        lateinit var application: MyApplication

    }

    /**
     * application context
     */
    lateinit var context: Context


    /**
     * onCreate
     *
     */
    override fun onCreate() {
        super.onCreate()
        //AppLocal.init(this)
        application = this
        context = this
        //initFirbae()
    }

    /*fun initFirbae() {
        FirebaseApp.initializeApp(this)
        //initFirbase()
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.d("FCM_reg_tokenfailed", task.exception.toString())
                return@OnCompleteListener
            }
            try {
                // Get new FCM registration token
                val token = task.result

                // Log and toast
                val msg = token
                Log.d("TAG", msg!!.toString())
                SharedPreferenceUtility.getInstance().save(Constant.FIREBASETOKEN, token)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        })
    }*/



    /**
     * get app context instance
     *
     * @return
     */
    fun getInstance(): MyApplication {
        return application
    }

    /**
     * get app context instance
     *
     * @return
     */
    fun getAppContext(): Context {
        return context
    }


}