package com.femiras.framework.mvvm.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.femiras.framework.mvvm.ui.home.anaylsis.AnalysisFragment
import com.femiras.framework.mvvm.ui.home.questions.QuestionsFragment
import com.femiras.framework.mvvm.ui.home.resource.ResourceFragment
import com.femiras.framework.mvvm.ui.home.today.TodayFragment

class HomePagerAdapter (
    fm: FragmentManager,
    behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) : FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TodayFragment.newInstance()
            1 -> AnalysisFragment.newInstance()
            else -> QuestionsFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "TODAY"
            1 -> "ANALYSIS"
            else -> "QUESTIONS"
        }
    }

    override fun getCount(): Int = 3
}