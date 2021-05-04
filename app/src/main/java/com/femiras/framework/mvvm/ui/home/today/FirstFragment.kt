package com.femiras.framework.mvvm.ui.home.today

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.LayoutBodyTemperatureBinding
import com.femiras.framework.mvvm.databinding.LayoutMenstruationBinding
import com.femiras.framework.mvvm.databinding.LayoutSexBinding
import com.femiras.framework.mvvm.databinding.LayoutStressBinding
import com.femiras.framework.mvvm.ui.home.HomeFragmentDirections
import com.femiras.framework.mvvm.ui.home.today.sex.SexListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*

@AndroidEntryPoint
class FirstFragment : Fragment(), SexListener {
    var firstAdapter: FirstAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstAdapter = FirstAdapter(requireContext(),this)
        first_list?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

            adapter = firstAdapter
        }


    }
    fun showCreatePlaylistDialog() {
        val playlistBinding = LayoutSexBinding.inflate(this.layoutInflater)
        val dialogBuilder = android.app.AlertDialog.Builder(requireContext()).setView(playlistBinding.root)
        val alertDialog: android.app.AlertDialog = dialogBuilder.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
        playlistBinding.radioHadSex.setOnClickListener { playlistBinding.protectedSex.visibility=View.VISIBLE

            playlistBinding.radioGroupNoSex.clearCheck()}
        playlistBinding.radioMultipleSex.setOnClickListener { playlistBinding.protectedSex.visibility=View.VISIBLE
            playlistBinding.radioGroupNoSex.clearCheck()}
        playlistBinding.radioNoSex.setOnClickListener { playlistBinding.protectedSex.visibility=View.GONE
        playlistBinding.btns.clearCheck()
        playlistBinding.protectedSex.clearCheck()
        }
    }
    fun showBaserDialog() {
        val playlistBinding = LayoutBodyTemperatureBinding.inflate(this.layoutInflater)
        val dialogBuilder = android.app.AlertDialog.Builder(requireContext()).setView(playlistBinding.root)
        val alertDialog: android.app.AlertDialog = dialogBuilder.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
        playlistBinding.btnCancel.setOnClickListener { alertDialog.dismiss() }
    }
    fun showStressDialog() {
        val playlistBinding = LayoutStressBinding.inflate(this.layoutInflater)
        val dialogBuilder = android.app.AlertDialog.Builder(requireContext()).setView(playlistBinding.root)
        val alertDialog: android.app.AlertDialog = dialogBuilder.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }

    }
    fun showMenstruationDialog() {
        val playlistBinding = LayoutMenstruationBinding.inflate(this.layoutInflater)
        val dialogBuilder = android.app.AlertDialog.Builder(requireContext()).setView(playlistBinding.root)
        val alertDialog: android.app.AlertDialog = dialogBuilder.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }

    }
    override fun onLoad(type: String) {
        when (type) {
            "Sex" ->
                showCreatePlaylistDialog()

            "Stress" ->     showStressDialog()
            "Mood" ->      findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToMoodFragment(

                )
            )
            "Symptoms"   ->      findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToHomeSymtoms(

                )
            )
            "BBT" ->   showBaserDialog()
            "Menstruation"->showMenstruationDialog()

        }
       Log.e("type","type"+type)
      ///  showMenstruationDialog()

    }
}