package com.example.nguyenthaikyduyen_311_eventvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPhone = findViewById<TextView>(R.id.tvPhone)
        val tvMsv = findViewById<TextView>(R.id.tvMsv)
        val tvClass = findViewById<TextView>(R.id.tvClass)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Nhận dữ liệu truyền qua Intent từ MainActivity
        val name = intent.getStringExtra("EXTRA_NAME") ?: ""
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        val phone = intent.getStringExtra("EXTRA_PHONE") ?: ""
        val msv = intent.getStringExtra("EXTRA_MSV") ?: ""
        val className = intent.getStringExtra("EXTRA_CLASS") ?: ""

        // Đổ dữ liệu lên giao diện
        tvName.text = "Họ và tên: $name"
        tvEmail.text = "Email: $email"
        tvPhone.text = "Số điện thoại: $phone"
        tvMsv.text = "Mã sinh viên: $msv"
        tvClass.text = "Lớp: $className"

        // Nút quay lại màn hình trước
        btnBack.setOnClickListener {
            finish()
        }
    }
}