package kr.co.tjoeun.listview_20201031.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.listview_20201031.R
import kr.co.tjoeun.listview_20201031.datas.Student
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(
    val mContext:Context,
    val resld:Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resld, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }
        val row = tempRow!!

//        row가 바로 결과가 되지 말고, 가공을 거친 후에 결과가 되게 하자.

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)

        val studentData = mList[position]

        nameTxt.text = studentData.name
        addressTxt.text = studentData.address

//        생년을 가지고 그대로 찍으면 잘못된 데이터. => 나이로 변환 해야함. (알고리즘 고민)

//        알고리즘 예시 : 생년을 가지고 -> (앱을 킨 시점 기준) 나이를 구하기.

//        현재시간의 일/시/분/초/년/월 등등 모두 저장됨.
        val now = Calendar.getInstance()
        val  age = now.get(Calendar.YEAR) - studentData.birthYear + 1

        ageTxt.text = "${age}세"

        return row


    }

}