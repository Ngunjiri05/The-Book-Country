package com.example.mymusicproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PdfListAdminActivity : AppCompatActivity() {

    private var categoryId = ""
    private var category = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_list)

        val intent = intent
        categoryId = intent.getStringExtra("categoryId")!!
        category = intent.getStringExtra("category")!!

    }
}