package kr.co.tjoeun.listview_20201031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
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

        studentListView.setOnItemClickListener { parent, view, position, id ->

//            position : 눌린 위치가 어디인지 알려주는 역할
//            위치에 맞는 학생의 이름을 토스트로 출력

            val clickedStudent = mStudentList[position]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()

        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

//            해당 줄을 길게 누르면 실행할 코드를 적는 공간.
//            오래 눌린 학생을 목록에서 제거하자. (ArrayList - remove)

            val longClickedStd = mStudentList[position]

            Log.d("롱클릭이벤트", longClickedStd.name)

            Log.d("삭제전 갯수", mStudentList.size.toString())

//            mStudentList.remove(longClickedStd)  // "학생"을 삭제하자
            mStudentList.removeAt(position)  // 해당 "위치"의 데이터 삭제

//            어댑터에게 변경사항 공지함. 새로 반영해라.
            mAdapter.notifyDataSetChanged()

            Log.d("삭제후 갯수", mStudentList.size.toString())

//            Boolean (true / false)값으로 결과를 지정(return)해야함. (안한 상태에서는 에러 처리)

            return@setOnItemLongClickListener true


        }

    }
}