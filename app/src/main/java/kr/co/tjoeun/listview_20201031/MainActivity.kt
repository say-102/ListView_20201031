package kr.co.tjoeun.listview_20201031

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.listview_20201031.Adapters.StudentAdapter
import kr.co.tjoeun.listview_20201031.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter
//    lateinit -> 나중에 대입할게 하는거

    val REQ_FOR_STUDENT_INFO = 1000

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

//            정말로 삭제할지 우선 물어보자. => 경고창을 만들어서 띄워주자.
//            확인이 눌렸을때만, 목록에서 제거

            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 명부 삭제")
            alert.setMessage("정말 해당 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

//                확인이 눌리면 할 일을 적는 공간

//            오래 눌린 학생을 목록에서 제거하자. (ArrayList - remove)

                val longClickedStd = mStudentList[position]

                Log.d("롱클릭이벤트", longClickedStd.name)

                Log.d("삭제전 갯수", mStudentList.size.toString())

//            mStudentList.remove(longClickedStd)  // "학생"을 삭제하자
                mStudentList.removeAt(position)  // 해당 "위치"의 데이터 삭제

//            어댑터에게 변경사항 공지함. 새로 반영해라.
                mAdapter.notifyDataSetChanged()

                Log.d("삭제후 갯수", mStudentList.size.toString())

            })
            alert.setNegativeButton("취소", null)

            alert.show()



//            Boolean (true / false)값으로 결과를 지정(return)해야함. (안한 상태에서는 에러 처리)

            return@setOnItemLongClickListener true

        }

//        학생 추가하기 버튼 이벤트
        makeNewStudentBtn.setOnClickListener {

            val myIntent = Intent(this, EditStudentInfoActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_STUDENT_INFO)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_STUDENT_INFO) {

            if (resultCode == Activity.RESULT_OK) {

//                학생정보를 가지러 다녀온것도 맞고,
//                확인을 누른것도 맞는 상황. => 첨부한 데이터를 가지고 사용하자.

//                첨부된 데이터로 => 학생을 새로 만들어서 => 목록에 추가

                val newStudent = Student(
                    data!!.getStringExtra("name")!!,
                    "${data!!.getStringExtra("largeArea")} ${data!!.getStringExtra("smallArea")}",
                    data!!.getIntExtra("birthYear", 1970))

                mStudentList.add(newStudent)

                mAdapter.notifyDataSetChanged()

            }
        }

    }

}