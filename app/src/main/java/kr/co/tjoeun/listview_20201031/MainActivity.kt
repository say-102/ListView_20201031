package kr.co.tjoeun.listview_20201031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.tjoeun.listview_20201031.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", "서울시 은평구", 1988))
        mStudentList.add(Student("구본아", "서울시 용산구", 1991))
        mStudentList.add(Student("김하은", "서울시 구로구", 1995))
        mStudentList.add(Student("박성윤", "인천시 연수구", 1996))
        mStudentList.add(Student("조윤주", "서울시 구로구", 1996))

    }
}