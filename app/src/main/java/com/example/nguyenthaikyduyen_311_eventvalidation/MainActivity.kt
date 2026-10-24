package com.example.nguyenthaikyduyen_311_eventvalidation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etMsv = findViewById<EditText>(R.id.etMsv)
        val etClass = findViewById<EditText>(R.id.etClass)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val msv = etMsv.text.toString().trim()
            val className = etClass.text.toString().trim()

            // 1. Validate Họ tên
            if (name.isEmpty()) {
                etName.error = "Họ tên không được để trống"
                etName.requestFocus()
                return@setOnClickListener
            }

            // 2. Validate Email
            if (email.isEmpty()) {
                etEmail.error = "Email không được để trống"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Định dạng email không hợp lệ"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            // 3. Validate Số điện thoại
            if (phone.isEmpty()) {
                etPhone.error = "Số điện thoại không được để trống"
                etPhone.requestFocus()
                return@setOnClickListener
            }
            if (!phone.matches(Regex("^0\\d{9}$"))) {
                etPhone.error = "SĐT phải có 10 chữ số và bắt đầu bằng số 0"
                etPhone.requestFocus()
                return@setOnClickListener
            }

            // 4. Validate Mã sinh viên
            if (msv.isEmpty()) {
                etMsv.error = "Mã sinh viên không được để trống"
                etMsv.requestFocus()
                return@setOnClickListener
            }

            // 5. Validate Lớp
            if (className.isEmpty()) {
                etClass.error = "Lớp không được để trống"
                etClass.requestFocus()
                return@setOnClickListener
            }

            // Nếu vượt qua tất cả validation -> Hiển thị Snackbar thành công kèm nút chuyển trang
            Snackbar.make(it, "Đăng ký thành công!", Snackbar.LENGTH_LONG)
                .setAction("Xem chi tiết") {
                    val intent = Intent(this, DetailActivity::class.java).apply {
                        putExtra("EXTRA_NAME", name)
                        putExtra("EXTRA_EMAIL", email)
                        putExtra("EXTRA_PHONE", phone)
                        putExtra("EXTRA_MSV", msv)
                        putExtra("EXTRA_CLASS", className)
                    }
                    startActivity(intent)
                }.show()
        }
    }
}