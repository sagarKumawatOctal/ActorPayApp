package com.octal.actorpay.ui.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.octal.actorpay.databinding.ItemFeaturesBinding

class FeaturesAdapter( private var mList: List<String>,
                       private var mContext: Context
) : RecyclerView.Adapter<FeaturesAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFeaturesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeaturesAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
    inner class ViewHolder(val binding: ItemFeaturesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            with(binding) {
               /* Glide.with(mContext).load(data.company_logo).into(image)
                txtNameID.setText(data.company_name)*/
            }
        }
    }
}