package com.example.typicoderetrofit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.typicoderetrofit.R
import com.example.typicoderetrofit.fragment.adapter.HospitalAdapter
import com.example.typicoderetrofit.model.HospitalsItem
import com.example.typicoderetrofit.viewmodel.HospitalViewModel
import kotlinx.android.synthetic.main.fragment_hospital.*


class HospitalFragment : Fragment(),HospitalAdapter.ClickListener{
    lateinit var hospitalViewModel:HospitalViewModel
    lateinit var hospitalAdapter:HospitalAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hospitalViewModel = ViewModelProvider(this).get(HospitalViewModel::class.java)
        hospitalAdapter = HospitalAdapter()
        recyclerHospital.layoutManager = LinearLayoutManager(context)
        recyclerHospital.adapter = hospitalAdapter
        hospitalViewModel.getHospital().observe(viewLifecycleOwner, Observer { hospitalAdapter.updateHospital(it.hospitals as List<HospitalsItem>) })
        hospitalAdapter.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        hospitalViewModel.loadHospital()
    }

    override fun onClick(hospitalsItems: HospitalsItem) {
        var hospital_id = hospitalsItems.hospitalId
        var hospital_name = hospitalsItems.hospitalName
        var hospital_image = hospitalsItems.hospitalImage
        var action = HospitalFragmentDirections.actionHospitalFragmentToDetailsFragment(hospital_id.toString(),hospital_name.toString(),hospital_image.toString())
        findNavController().navigate(action)
    }

}