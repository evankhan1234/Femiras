package com.femiras.framework.mvvm.ui.home.resource

import android.app.Dialog
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.ThirdAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_third.*

import kotlinx.android.synthetic.main.layout_resources_high.view.*


class ResourceDetailsFragment : BottomSheetDialogFragment() ,ResourceListener{
    private var mBehavior: BottomSheetBehavior<*>? = null
    var img_back: ImageView?=null
    var img_name: ImageView?=null
    var tv_tt: TextView?=null
    var third_list: RecyclerView?=null
    var third_lists: RecyclerView?=null
    var resourceLowAdapter: ResourceLowAdapter?=null
    var resourceDetailsAdapter: ResourceDetailsAdapter?=null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =
            super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        val view =
            View.inflate(context, R.layout.fragment_resource_details, null)
        img_back=view.findViewById(R.id.backToTransactionButton)
        img_name=view.findViewById(R.id.imageView4)
        tv_tt=view.findViewById(R.id.tv_tt)
        third_list=view.findViewById(R.id.third_list)
        third_lists=view.findViewById(R.id.third_lists)
        val  discount_prices =
            "<b> <font color=#000>Femiras Medical Board  </font> : </b>" +"50+ doctors and experts from Europe and North America"
        tv_tt?.text = Html.fromHtml(discount_prices!!)
        Glide.with(this)
            .load("https://www.globalblue.com/business/images/article926851.ece/BINARY/TFS_Article_2019_970x643.jpg")
            .into( img_name!!)
        img_back?.setOnClickListener {
            dismiss()
        }
        resourceDetailsAdapter = ResourceDetailsAdapter(requireContext(),this)
        resourceLowAdapter = ResourceLowAdapter(requireContext(),this)
        third_list?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = resourceDetailsAdapter
        }
        third_lists?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = resourceLowAdapter
        }
        dialog.setContentView(view)

        mBehavior =
            BottomSheetBehavior.from(view.parent as View)



        return dialog
    }
    override fun onStart() {
        super.onStart()
        mBehavior?.setState(BottomSheetBehavior.STATE_EXPANDED)
    }

    override fun onShow(data: Int) {
        findNavController().navigate(
            ResourceDetailsFragmentDirections.actionMenuDetailsToMenuListDetails()
        )
    }


}