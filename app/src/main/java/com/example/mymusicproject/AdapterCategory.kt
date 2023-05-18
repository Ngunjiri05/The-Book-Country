package com.example.mymusicproject

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusicproject.databinding.RowCategoryBinding
import com.google.firebase.database.FirebaseDatabase

class AdapterCategory :RecyclerView.Adapter<AdapterCategory.HolderCategory>, Filterable,
    ListAdapter {

    private val context: Context
   var categoryArrayList: ArrayList<ModelCategory>
   private var filterList: ArrayList<ModelCategory>

   private var filter: FilterCategory? = null

   constructor(context: Context, categoryArrayList: ArrayList<ModelCategory>){
       this.context = context
       this.categoryArrayList = categoryArrayList
       this.filterList = categoryArrayList
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCategory {
        binding = RowCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return HolderCategory(binding.root)
    }

    override fun getItemCount(): Int {
       return categoryArrayList.size //number of items in list

    }

    override fun onBindViewHolder(holder: HolderCategory, position: Int) {
        /*-----Get Data, Set Data, Handle click---*/
        val model = categoryArrayList[position]
        val id = model.id
        val category = model.category
        val uid = model.uid
        val timestamp = model.timestamp

        holder.categoryTv.text = category

        holder.deleteBtn.setOnClickListener{
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete")
                .setMessage("Are you sure you want to delete this caategory?")
                .setPositiveButton("Confirm"){a, d->
                    Toast.makeText(context,"Deleting...", Toast.LENGTH_SHORT).show()
                    deleteCategory(model, holder)
                }

                .setPositiveButton("Cancel"){a, d->
                    a.dismiss()
                }
                .show()
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(context, PdfListAdminActivity::class.java)
            intent.putExtra("categoryId", id)
            intent.putExtra("category", category)
            context.startActivity(intent)
        }

    }

    private fun deleteCategory(model: ModelCategory, holder: HolderCategory) {
          val id = model.id
        val ref = FirebaseDatabase.getInstance().getReference("Categories")
        ref.child(id)
            .removeValue()
            .addOnSuccessListener {
                Toast.makeText(context, "Deleted...", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{e->
                Toast.makeText(context, "Unable to delete due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private lateinit var binding: RowCategoryBinding
    inner class HolderCategory(itemView: View): RecyclerView.ViewHolder(itemView){
        var categoryTv:TextView = binding.mEdtCatTv
        var deleteBtn:ImageButton = binding.mBtnDelete

    }

    override fun getFilter(): Filter {
        if (filter == null){
            filter = FilterCategory(filterList, this)
        }
        return filter as FilterCategory
    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun areAllItemsEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(p0: Int): Boolean {
        TODO("Not yet implemented")
    }


}