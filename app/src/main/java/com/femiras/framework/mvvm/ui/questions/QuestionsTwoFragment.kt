package com.femiras.framework.mvvm.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.utils.EventDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

import kotlinx.android.synthetic.main.fragment_questions_two.imageView13
import org.threeten.bp.LocalDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class QuestionsTwoFragment : Fragment() {

    val pinkDateList = Arrays.asList(
            "2021-04-15",
            "2021-04-16", "2021-04-17", "2021-04-18", "2021-04-19", "2021-04-20", "2021-04-21")
    val grayDateList = Arrays.asList(
            "2019-01-09", "2019-01-10", "2019-01-11",
            "2019-01-24", "2019-01-25", "2019-01-26", "2019-01-27", "2019-01-28", "2019-01-29")

    val DATE_FORMAT = "yyyy-MM-dd"

    var pink = 0
    var gray = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_two, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageView13.setOnClickListener{
        }
        imageView13!!.showOtherDates = MaterialCalendarView.SHOW_ALL

        val min: LocalDate = getLocalDate("2021-04-15")!!
        val max: LocalDate = getLocalDate("2021-04-21")!!

        imageView13!!.state().edit().setMinimumDate(min).setMaximumDate(max).commit()


        setEvent(pinkDateList, pink)
        setEvent(grayDateList, gray)

        imageView13!!.invalidateDecorators()
    }
    fun setEvent(dateList: List<String?>, color: Int) {
        val localDateList: MutableList<LocalDate> = ArrayList()
        for (string in dateList) {
            val calendar = getLocalDate(string)
            if (calendar != null) {
                localDateList.add(calendar)
            }
        }
        val datesLeft: MutableList<CalendarDay> = ArrayList()
        val datesCenter: MutableList<CalendarDay> = ArrayList()
        val datesRight: MutableList<CalendarDay> = ArrayList()
        val datesIndependent: MutableList<CalendarDay> = ArrayList()
        for (localDate in localDateList) {
            var right = false
            var left = false
            for (day1 in localDateList) {
                if (localDate.isEqual(day1.plusDays(1))) {
                    left = true
                }
                if (day1.isEqual(localDate.plusDays(1))) {
                    right = true
                }
            }
            if (left && right) {
                datesCenter.add(CalendarDay.from(localDate))
            } else if (left) {
                datesLeft.add(CalendarDay.from(localDate))
            } else if (right) {
                datesRight.add(CalendarDay.from(localDate))
            } else {
                datesIndependent.add(CalendarDay.from(localDate))
            }
        }
        if (color == pink) {
            setDecor(datesCenter, R.drawable.p_center)
            setDecor(datesLeft, R.drawable.p_left)
            setDecor(datesRight, R.drawable.p_right)
            setDecor(datesIndependent, R.drawable.p_independent)
        } else {
            setDecor(datesCenter, R.drawable.g_center)
            setDecor(datesLeft, R.drawable.g_left)
            setDecor(datesRight, R.drawable.g_right)
            setDecor(datesIndependent, R.drawable.g_independent)
        }
    }

    fun setDecor(calendarDayList: List<CalendarDay>?, drawable: Int) {
        imageView13.addDecorators(EventDecorator(requireContext(), drawable, calendarDayList))
    }

    fun getLocalDate(date: String?): LocalDate? {
        val sdf = SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH)
        return try {
            val input = sdf.parse(date)
            val cal = Calendar.getInstance()
            cal.time = input
            LocalDate.of(cal[Calendar.YEAR],
                    cal[Calendar.MONTH] + 1,
                    cal[Calendar.DAY_OF_MONTH])
        } catch (e: NullPointerException) {
            null
        } catch (e: ParseException) {
            null
        }
    }
}