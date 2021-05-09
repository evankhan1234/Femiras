package com.femiras.framework.mvvm.ui.home.questions

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.LayoutResultBinding
import com.femiras.framework.mvvm.databinding.LayoutStressBinding
import com.femiras.framework.mvvm.ui.home.resource.ResourceAdapter
import com.femiras.framework.mvvm.ui.home.resource.ResourceTypeAdapter
import com.femiras.framework.mvvm.ui.home.today.sex.SexListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_questions.*

@AndroidEntryPoint
class QuestionsFragment : Fragment() , SexListener {
    var questionsAdapter: QuestionsAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }
    companion object {
        @JvmStatic
        fun newInstance() = QuestionsFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionsAdapter = QuestionsAdapter(requireContext(),this)
        rc_questions?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = questionsAdapter
        }


    }
    fun showStressDialog() {
        val playlistBinding = LayoutResultBinding.inflate(this.layoutInflater)
        val dialogBuilder = android.app.AlertDialog.Builder(requireContext()).setView(playlistBinding.root)
        val alertDialog: android.app.AlertDialog = dialogBuilder.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }

    }
    override fun onLoad(type: String) {
        showStressDialog()
    }

}