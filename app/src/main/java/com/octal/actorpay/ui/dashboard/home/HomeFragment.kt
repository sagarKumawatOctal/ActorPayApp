package com.octal.actorpay.ui.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.octal.actorpay.NavController
import com.octal.actorpay.R
import com.octal.actorpay.databinding.FragmentHomeBinding
import com.octal.actorpay.ui.dashboard.adapter.FeaturesAdapter
import com.octal.actorpay.ui.dashboard.adapter.MenuAdapter
import com.octal.actorpay.ui.dashboard.adapter.TransactionAdapter
import com.octal.actorpay.ui.dashboard.models.DrawerItems
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle


class HomeFragment : Fragment(), DuoMenuView.OnMenuClickListener,
    AdapterView.OnItemSelectedListener {
    private var mTitles = ArrayList<DrawerItems>()
    private var mViewHolder: ViewHolder? = null
    private var mMenuAdapter: MenuAdapter? = null
    private lateinit var rootView: View
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //rootView = inflater.inflate(R.layout.fragment_home, container, false)
        initiliation()
        setBottomNavigationView()
        features()
        gettransaction()
        return root
    }

    private fun gettransaction() {
        binding.layoutMainID.rvtransactionID.apply {
            var arraylist: ArrayList<String> = arrayListOf("AddMoney", "AddMoney", "AddMoney")
            adapter = TransactionAdapter(arraylist, requireActivity())
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun features() {
        binding.layoutMainID.rvItemsID.apply {
            var arraylist: ArrayList<String> = arrayListOf("AddMoney", "AddMoney", "AddMoney")
            adapter = FeaturesAdapter(arraylist, requireActivity())
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)

        }

    }

    private fun setBottomNavigationView() {
        /*val bottomnav: BottomNavigationView
        bottomnav = rootView.findViewById(R.id.bottomNavigationView)*/
        binding.layoutMainID.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_fragment -> {
                    NavController().navigateWithId(R.id.homeFragment, findNavController())
                }
                R.id.history_fragment -> {
                    NavController().navigateWithId(R.id.homeFragment, findNavController())
                }
                R.id.wallet_fragment -> {
                    NavController().navigateWithId(R.id.walletFragment, findNavController())
                }
                R.id.profile_fragment -> NavController().navigateWithId(
                    R.id.homeFragment,
                    findNavController()
                )
            }
            true
        }
    }

    private inner class ViewHolder internal constructor() {
        val mDuoDrawerLayout: DuoDrawerLayout = binding.drawer
        val mDuoMenuView: DuoMenuView
        val mToolbar: Toolbar

        init {
            mDuoMenuView = mDuoDrawerLayout.menuView as DuoMenuView
            mToolbar = binding.toolbarLayout.toolbar

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

    private fun handleToolbar() {
        (activity as AppCompatActivity?)!!.setSupportActionBar(mViewHolder?.mToolbar)
        mViewHolder?.mToolbar?.setTitleTextColor(resources.getColor(R.color.white))

    }


    private fun handleMenu() {
        mMenuAdapter = MenuAdapter(requireActivity(), mTitles)
        mViewHolder?.mDuoMenuView?.setOnMenuClickListener(this)
        mViewHolder?.mDuoMenuView?.adapter = mMenuAdapter
    }

    private fun handleDrawer() {
        val duoDrawerToggle = DuoDrawerToggle(
            requireActivity(),
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
        requireActivity().title = mTitles[position].mTitle
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
                //showCustomToast("screen")
                /* val intent = Intent(applicationContext, Profile::class.java)
                 startActivity(intent)*/
            }
            2 -> {
                //showCustomToast("screen")
                /*val intent = Intent(applicationContext, Wallet::class.java)
                startActivity(intent)*/

            }
            3 -> {
                //showCustomToast("screen")
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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

}