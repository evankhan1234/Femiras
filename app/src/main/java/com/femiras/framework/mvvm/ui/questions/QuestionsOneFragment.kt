package com.femiras.framework.mvvm.ui.questions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.extension.launchActivity
import com.femiras.framework.mvvm.ui.spalash.SignInContentFragmentDirections
import kotlinx.android.synthetic.main.fragment_o_t_p.*


class QuestionsOneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backToTransactionButton.setOnClickListener{
            if (findNavController().currentDestination?.id != R.id.questionsTwoFragment && findNavController().currentDestination?.id == R.id.questionsOneFragment) {
                findNavController().navigate(
                        QuestionsOneFragmentDirections.actionQuestionsOneFragmentToSquestionsTwoFragment(

                        )
                )
            }
        }
    }
}