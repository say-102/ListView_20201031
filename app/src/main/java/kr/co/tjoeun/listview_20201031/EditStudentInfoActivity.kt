package kr.co.tjoeun.listview_20201031

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_student_info.*

class EditStudentInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student_info)

        okBtn.setOnClickListener {

//            1. 입력한 항목들 받아내기

            val inputName = nameEdt.text.toString()
            val largeArea = largeAreaEdt.text.toString()
            val smallArea = smallAreaEdt.text.toString()

//            년도는 정수 (Int) 형태로 저장하는게 편리함.
//            입력문구(text) -> String 변환 -> Int 변환 : 대입시키자
            val birthYear = birthYearEdt.text.toString()

//            2. 결과로써 설정 (+ 확인을 누른게 맞다)

            val resultIntent = Intent()
            resultIntent.putExtra("name", inputName)
            resultIntent.putExtra("largeArea", largeArea)
            resultIntent.putExtra("smallArea", smallArea)
            resultIntent.putExtra("birthYear", birthYear)

            setResult(Activity.RESULT_OK, resultIntent)

//            3. 이전화면으로 복귀
            finish()

        }


    }
}