package com.example.mymusicproject

import android.app.Application
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.github.barteksc.pdfviewer.PDFView
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class MyApplication: Application()
{
    override fun onCreate() {
        super.onCreate()
    }
    companion object
    //created a static method to convert timestamp to proper date format, so we can use it everywhere in project, no need to rewirte
    fun formatTimeStamp (timestamp: Long) : String {
        val cal = Calendar.getInstance(Locale.ENGLISH)
        cal.timeInMillis = timestamp
        //format dd/MM/yyyy
        return DateFormat.format("dd/MM/YYYY", cal).toString()
        //function to get pdf size
        fun LoadPdfSize(pdfurl: String, pdfTitle: String, sizeTv: TextView) {
            val TAG = "PDF_SIZE_TAG"

            //using url we can get file and its medata from firebase storage
            val ref = FirebaseStorage.getInstance().getReferenceFromUrl(pdfurl)
            ref.metadata
                .addOnSuccessListener { storageMetaData ->
                    Log.d(TAG, "LoadPdfSize: got metadata")
                    val bytes = storageMetaData.sizeBytes.toDouble()
                    Log.d(
                        TAG,
                        "LoadPdfSize: Size Bytes $bytes"
                    )
                    //convert bytes to KB/MB
                    val kb = bytes / 1024
                    val mb = kb / 1024
                    if (mb >= 1) {
                        sizeTv.text = "${String.format("$.2f", mb)} MB"
                    } else if (kb >= 1) {
                        sizeTv.text = "${String.format("$.2f", kb)} KB"
                    } else {
                        sizeTv.text = "${String.format("$.2f", kb)} KB"
                    }
                }
                            .addOnFailureListener { e ->
                                Log.d(TAG, "LoadPdfSize: Failed to get metada due to ${e.message}")
                            }
        }





      fun loadPdfFromUrlSinglePage(
          pdfurl: String,
          pdfTitle: String,
          pdfView: PDFView,
          progressBar: ProgressBar,
          pagesTv: TextView
      ) {


          val TAG = "POF_THUNBNNATL TAG"

//using url we can get file and its metadata from firebase storage
          val ref = FirebaseStorage.getInstance().getReferenceFromUrl(pdfurl)
          ref.metadata
              .addOnSuccessListener { storageMetaData ->
                  Log.d(TAG, "LoadPdfSize: got metadata")
                  val bytes = storageMetaData.sizeBytes.toDouble()
                  Log.d(TAG, "LoadPdfSize: Size Bytes $bytes")


//SET TO POFVIEW
                  pdfView.fromBytes(bytes)
                      .pages(0) //show first page only
                      .spacing(0)
                      .swipeHorizontal(false)
                      .enableSwipe(false)
                      .onError { t ->
                          progressBar.visibility = View.INVISIBLE
                      }
                      .onPageError { page, t ->
                  progressBar.visibility = View. INVISIBLE
                          Log.d(TAG,"LoadPatFromUrsinglePage: ${t.message}")
              }
                      .onLoad { nbPages ->
                          progressBar.visibility = View.INVISIBLE
                       if (pagesTv != null){
                           pagesTv.text = "$nbPages"
                       }

                      }
              }

              .addOnFailureListener { e ->
                  Log.d(
                      TAG,
                      "LoadPdfSize: Failed to get metada due to  ${e. message}"
                  )
              }

      }
    }
}



