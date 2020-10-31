package kr.co.tjoeun.listview_20201031.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kr.co.tjoeun.listview_20201031.R
import kr.co.tjoeun.listview_20201031.datas.Student

class StudentAdapter(
    val mContext:Context,
    val resld:Int,
    val mList : ArrayAdapter<Student>) : ArrayAdapter<Student>(mContext, resld, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }
        val row = tempRow!!

        return row


    }

}