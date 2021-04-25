package com.femiras.framework.mvvm.ui.home.log

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.extension.launchActivity
import com.femiras.framework.mvvm.ui.HomeActivity
import com.femiras.framework.mvvm.utils.EventDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import kotlinx.android.synthetic.main.fragment_log.*
import kotlinx.android.synthetic.main.fragment_log.imageView13
import kotlinx.android.synthetic.main.fragment_questions_two.*
import org.threeten.bp.LocalDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class LogFragment : Fragment() {
    val pinkDateList = Arrays.asList(
        "2021-03-08",
        "2021-03-09", "2021-03-10", "2021-03-11", "2021-03-12")
    val blueDateList = Arrays.asList(
        "2021-03-13", "2021-03-14", "2021-03-15", "2021-03-16", "2021-03-17", "2021-03-18"
    )
    val grayDateList = Arrays.asList(
        "2021-03-19", "2021-03-20", "2021-03-21", "2021-03-22", "2021-03-23", "2021-03-24", "2021-03-25", "2021-03-26", "2021-03-27", "2021-03-28", "2021-03-29", "2021-03-30",
        "2021-03-31"

    )
    val DATE_FORMAT = "yyyy-MM-dd"

    var pink = 0
    var blue = 2
    var gray = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val min: LocalDate = getLocalDate("2021-04-01")!!
        val max: LocalDate = getLocalDate("2021-04-30")!!

        imageView13!!.state().edit().setMinimumDate(min).setMaximumDate(max).commit()

        imageView1.state().edit()
            .setMaximumDate(CalendarDay.from(2021, 3, 1))
            .setMaximumDate(CalendarDay.from(2021, 3, 31))
            .commit();
        setEvent(pinkDateList, pink)
        setEvent(grayDateList, gray)
        setEvent(blueDateList, blue)

        imageView1!!.invalidateDecorators()


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
            setDecor(datesLeft, R.drawable.p_center)
            setDecor(datesRight, R.drawable.p_center)
            setDecor(datesIndependent, R.drawable.p_center)
        }
        else if (color == blue) {
            setDecor(datesCenter, R.drawable.g_center)
            setDecor(datesLeft, R.drawable.g_center)
            setDecor(datesRight, R.drawable.g_center)
            setDecor(datesIndependent, R.drawable.g_center)

        } else {
            setDecor(datesCenter, R.drawable.circular)
            setDecor(datesLeft, R.drawable.circular)
            setDecor(datesRight, R.drawable.circular)
            setDecor(datesIndependent, R.drawable.circular)
        }
    }

    fun setDecor(calendarDayList: List<CalendarDay>?, drawable: Int) {
        imageView1.addDecorators(EventDecorator(requireContext(), drawable, calendarDayList))
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