package com.example.floatingactionbutton

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 플로팅 버튼 클릭 시 동작
        fabMain.setOnClickListener {
            toggleFab()
        }
        // 플로팅 버튼에 번호 추가 시 동작
        fabAdd.setOnClickListener {
            Toast.makeText(this, "click add number button", Toast.LENGTH_SHORT).show()
        }
    }

    /* 플로팅 액션버튼 클릭 시 동작하는 애니메이션 효과 세팅 */
    private fun toggleFab() {
        Toast.makeText(this, "click main floating button", Toast.LENGTH_SHORT).show()

        // 플로팅 액션 버튼 닫기
        if(isFabOpen) {
            ObjectAnimator.ofFloat(fabAdd, "translationY", 0f).apply { start() }
            fabMain.setImageResource(R.drawable.add)
        } else { // 플로팅 액션 버튼 열기
            ObjectAnimator.ofFloat(fabAdd, "translationY", -200f).apply { start() }
            fabMain.setImageResource(R.drawable.close)
        }
        isFabOpen = !isFabOpen
    }
}