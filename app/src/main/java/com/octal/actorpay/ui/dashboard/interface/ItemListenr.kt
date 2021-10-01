package com.octal.actorpay.ui.dashboard.`interface`

interface ItemListenr {
    fun on_ItemClickListner(
        position: Int,
        mList: List<String>
    )
}