package com.example.v2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.joanzapata.pdfview.PDFView
import com.joanzapata.pdfview.listener.OnPageChangeListener
import android.app.Activity
import android.content.Intent
import android.widget.Button

class PDF_View : Activity() , OnPageChangeListener {
    companion object {

        const val ABOUT_FILE = "Sample_statement (1).pdf"
    }

    private lateinit var pdfView: PDFView

    private var pdfName = ABOUT_FILE
    private var pageNumber = 1
    private lateinit var backbutton: Button







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pdf_view)

        pdfView = findViewById(R.id.pdfView)
        display(pdfName, false)


        backbutton= findViewById(R.id.backbutton)
        backbutton.setOnClickListener {
            val intent = Intent(this, MonthlyExport::class.java)
            startActivity(intent)
            finish()
        }







    }
    private fun display(assetFileName: String, jumpToFirstPage: Boolean) {
        if (jumpToFirstPage)
            pageNumber = 1
        setTitle(assetFileName)
        pdfName = assetFileName

        pdfView.fromAsset(assetFileName)
            .defaultPage(pageNumber)
            .onPageChange(this)
            .load()
    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        pageNumber = page
        setTitle(pageNumber.toString())
    }

}