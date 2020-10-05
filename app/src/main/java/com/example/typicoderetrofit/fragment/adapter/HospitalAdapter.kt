package com.example.typicoderetrofit.fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.typicoderetrofit.R
import com.example.typicoderetrofit.model.Hospital
import com.example.typicoderetrofit.model.HospitalsItem
import kotlinx.android.synthetic.main.item_hospital.view.*

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {
    var clickListener: ClickListener? = null
    private var hospitalItem: List<HospitalsItem> = ArrayList()

    inner class HospitalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var hospitalsItems: HospitalsItem
        fun bind(hospitalsItems: HospitalsItem) {
            this.hospitalsItems = hospitalsItems
            itemView.hospitalName.text = hospitalsItems.hospitalName

        }

        override fun onClick(v: View?) {
            clickListener?.onClick(hospitalsItems)
        }

    }

    fun setOnClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hospital, parent, false)
        return HospitalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospitalItem[position])
    }

    override fun getItemCount(): Int = hospitalItem.size

    fun updateHospital(hospitalList: List<HospitalsItem>) {
        this.hospitalItem = hospitalList
        Log.d("hospitalList>>>>",hospitalList.toString())
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClick(hospitalsItems: HospitalsItem)
    }
}