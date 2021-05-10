package com.femiras.framework.mvvm.ui.home.questions

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.LayoutResultBinding
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
    fun showStressDialog( type:String) {
        val playlistBinding = LayoutResultBinding.inflate(this.layoutInflater)
        val dialogBuilder = android.app.AlertDialog.Builder(requireContext()).setView(playlistBinding.root)
        val alertDialog: android.app.AlertDialog = dialogBuilder.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
        if(type.equals("2")){
            playlistBinding.dialogTitleTextView1.text="Correct Answer : The Executor framework is a framework for standardizing invocation, scheduling, execution, and control of asynchronous tasks according to a set of execution policies."
            val img = ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_cancel_24);
            playlistBinding.dialogTitleTextView.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
            //playlistBinding.dialogTitleTextView.setCompoundDrawables(requireContext().getResources().getDrawable(R.drawable.ic_baseline_send_24),null,null,null)
            playlistBinding.dialogTitleTextView.text="Wrong Answer"
            playlistBinding.dialogTitleTextView.setTextColor(ContextCompat.getColor(requireContext(),R.color.secondaryTextColor))
            playlistBinding.dialogTitleTextView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.purple))
        }


        playlistBinding.radioHadSex.setOnClickListener { alertDialog.dismiss() }

    }
    override fun onLoad(type: String) {
        showStressDialog(type)
    }

}