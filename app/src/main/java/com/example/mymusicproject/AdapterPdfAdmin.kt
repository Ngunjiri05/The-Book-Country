package com.example.mymusicproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusicproject.databinding.RowPdfAdminBinding

class AdapterPdfAdmin:  RecyclerView.Adapter<AdapterPdfAdmin.Companion.HolderPdfAdmin>{
    private var context: Context

    private var pdfArrayList: ArrayList<Modefpdf>


    private lateinit var binding:RowPdfAdminBinding

    constructor(
        context: Context,
        pdfArrayList: ArrayList<Modefpdf>,

    ) : super() {
        this.context = context
        this.pdfArrayList = pdfArrayList

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Companion.HolderPdfAdmin {
       binding = RowPdfAdminBinding.inflate(LayoutInflater.from(context), parent, false)
   return Companion.HolderPdfAdmin(binding.root)
    }

    override fun getItemCount(): Int {
        return pdfArrayList.size
    }

    override fun onBindViewHolder(holder: Companion.HolderPdfAdmin, position: Int) {
      val model = pdfArrayList[position]
        val pdfId = model.id
        val categoryId = model.categoryId
        val title = model.title
        val description =model.description
        val pdfUrl = model.url
        val timestamp = model.timestamp
    }

    inner class  HolderPdfAdmin{
        inner class  HolderfPdfAdmin(itemView: View) : RecyclerView.ViewHolder(itemView){
     val pdfView = binding.pdfView
             val progressBar = binding.Progressbar
            val titleTv = binding.mEdttex
            val descriptionTv = binding.mEdtdes
            val categoryTv = binding.mEdtcat
            val sizeTv = binding.mEdtsize
            val dateRv = binding.mEdtDate
            val Btnmore = binding.mBtnMore
        }

    }

    companion object {
        class HolderPdfAdmin(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // HolderPdfAdmin implementation
        }
    }


}