package com.octal.actorpay

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.octal.actorpay.base.BaseActivity
import com.octal.actorpay.ui.dashboard.adapter.MenuAdapter
import com.octal.actorpay.ui.dashboard.models.DrawerItems
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle

class MainActivity : BaseActivity(), DuoMenuView.OnMenuClickListener,
    AdapterView.OnItemSelectedListener {
    //private lateinit var binding: ActivityMainBinding
    private var mTitles = ArrayList<DrawerItems>()
    private var mViewHolder: ViewHolder? = null
    private var mMenuAdapter: MenuAdapter? = null
    private val mNavControler: NavController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Data binding here
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /**
         * initialize the view-model
         */
        setContentView(R.layout.activity_main)
        initiliation()
        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {
        val bottomnav : BottomNavigationView
        bottomnav = findViewById(R.id.bottomNavigationView)
        /* replaceFragment(HomeFragment(),null)*/
        //findNavController(R.id.home_fragment)
        bottomnav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_fragment -> {
                    Navigation.findNavController(this,R.id.home_fragment) }
                R.id.history_fragment -> {  Navigation.findNavController(this,R.id.home_fragment) }
                R.id.wallet_fragment -> {  findNavController(this,R.id.home_fragment) }
                R.id.profile_fragment ->  findNavController(this,R.id.home_fragment)
            }
            true
        }
    }

    private fun initiliation() {
        mTitles.add(
            DrawerItems(
                getString(R.string.my_profile),
                this.resources.getDrawable(R.drawable.my_profile)!!
            )
        )
        mTitles.add(
            DrawerItems(
                getString(R.string.wallet_statement),
                this.resources.getDrawable(R.drawable.wallet_statement)!!
            )
        )
        mTitles.add(
            DrawerItems(
                getString(R.string.my_orders),
                this.resources.getDrawable(R.drawable.my_orders)!!
            )
        )
        mTitles.add(
            DrawerItems(
                getString(R.string.change_payment_option),
                this.resources.getDrawable(R.drawable.my_orders)!!
            )
        )
        mTitles.add(
            DrawerItems(
                getString(R.string.settings),
                this.resources.getDrawable(R.drawable.settings)!!
            )
        )
        mTitles.add(
            DrawerItems(
                getString(R.string.more),
                this.resources.getDrawable(R.drawable.more)!!
            )
        )
        // Initialize the views
        mViewHolder = ViewHolder()

        // Handle toolbar actions
        handleToolbar()

        // Handle menu actions
        handleMenu()

        // Handle drawer actions
        handleDrawer()

        //actionView here
        actionView()

    }

    private fun actionView() {


    }

    private inner class ViewHolder internal constructor() {
        val mDuoDrawerLayout: DuoDrawerLayout = findViewById(R.id.drawer)
        val mDuoMenuView: DuoMenuView
        val mToolbar: Toolbar

        init {
            mDuoMenuView = mDuoDrawerLayout.menuView as DuoMenuView
            mToolbar = findViewById(R.id.toolbar)

        }
    }

    private fun handleToolbar() {
        setSupportActionBar(mViewHolder?.mToolbar)
        mViewHolder?.mToolbar?.setTitleTextColor(resources.getColor(R.color.white))

    }


    private fun handleMenu() {
        mMenuAdapter = MenuAdapter(this, mTitles)
        mViewHolder?.mDuoMenuView?.setOnMenuClickListener(this)
        mViewHolder?.mDuoMenuView?.adapter = mMenuAdapter
    }

    private fun handleDrawer() {
        val duoDrawerToggle = DuoDrawerToggle(
            this,
            mViewHolder?.mDuoDrawerLayout,
            mViewHolder?.mToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        mViewHolder?.mDuoDrawerLayout?.setDrawerListener(duoDrawerToggle)
        duoDrawerToggle.syncState()
    }

    override fun onFooterClicked() {

    }

    override fun onHeaderClicked() {
        mViewHolder?.mDuoDrawerLayout?.closeDrawer()
    }

    override fun onOptionClicked(position: Int, objectClicked: Any?) {
        // Set the toolbar title
        title = mTitles[position].mTitle
        // Set the right options selected
        mMenuAdapter?.setViewSelected(position, true)

        // Navigate to the right fragment
        when (position) {
            /*0 -> {
                startActivity(Intent(this, KitchenListParent::class.java))
            }
    */
            0 -> {
                // showAlertBar("0")
                //bottomNavigationView.selectedItemId = R.id.bottomMenuMeals
                /* val intent = Intent(applicationContext, MyOrders::class.java)
                 startActivity(intent)*/

            }
            1 -> {
                showCustomToast("screen")
                /* val intent = Intent(applicationContext, Profile::class.java)
                 startActivity(intent)*/
            }
            2 -> {
                showCustomToast("screen")
                /*val intent = Intent(applicationContext, Wallet::class.java)
                startActivity(intent)*/

            }
            3 -> {
                showCustomToast("screen")
                /*val intent = Intent(applicationContext, Refer_and_Earn::class.java)
                startActivity(intent)*/
            }
            4 -> {
                /*val intent = Intent(applicationContext, RateAndReviews::class.java)
                startActivity(intent)*/
            }
            5 -> {
                //startActivity(Intent(this, NotificationActivity::class.java))
            }
            6 -> {
                //startActivity(Intent(applicationContext, MoreActivity::class.java))
            }
            7 -> {

            }
        }

        // Close the drawer
        mViewHolder?.mDuoDrawerLayout?.closeDrawer()
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}