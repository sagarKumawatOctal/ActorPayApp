package com.octal.actorpay.ui.dashboard.bottomnavfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.octal.actorpay.R
import com.octal.actorpay.databinding.FragmentWalletBottomBinding
import com.octal.actorpay.ui.dashboard.adapter.AdapterWalletStatement

class WalletBottomFragment : Fragment() {
    private var _binding: FragmentWalletBottomBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWalletBottomBinding.inflate(inflater, container, false)
        val root: View = binding.root
        gettransaction()
        return root
    }
    private fun gettransaction() {
        binding.rvItemsWalletID.apply {
            var arraylist: ArrayList<String> = arrayListOf("AddMoney", "AddMoney", "AddMoney")
            adapter = AdapterWalletStatement(arraylist, requireActivity())
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}