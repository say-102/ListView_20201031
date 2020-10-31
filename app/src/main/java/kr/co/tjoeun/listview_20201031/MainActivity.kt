package kr.co.tjoeun.listview_20201031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.tjoeun.listview_20201031.Adapters.StudentAdapter
import kr.co.tjoeun.listview_20201031.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter
//    lateinit -> 나중에 대입할게 하는거

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", "서울시 은평구", 1988))
        mStudentList.add(Student("구본아", "서울시 용산구", 1991))
        mStudentList.add(Student("김하은", "서울시 구로구", 1995))
        mStudentList.add(Student("박성윤", "인천시 연수구", 1996))
        mStudentList.add(Student("조윤주", "서울시 구로구", 1996))
        mStudentList.add(Student("아이유", "서울시 금천구", 1993))
        mStudentList.add(Student("박보검", "서울시 강남구", 1993))
        mStudentList.add(Student("박보영", "경기도 고양시", 1990))
        mStudentList.add(Student("차은우", "서울시 도봉구", 1997))
        mStudentList.add(Student("정우성", "서울시 강북구", 1973))

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)
        studentListView.adapter = mAdapter

    }
}