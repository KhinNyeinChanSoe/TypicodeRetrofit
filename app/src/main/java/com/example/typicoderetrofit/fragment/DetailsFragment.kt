package com.example.typicoderetrofit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.typicoderetrofit.R
import com.example.typicoderetrofit.viewmodel.DetailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {
    lateinit var detailViewModel:DetailsViewModel
    lateinit var id :String
    lateinit var name:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var messageArgs = arguments?.let {
            DetailsFragmentArgs.fromBundle(it)
        }
        id = messageArgs?.id.toString()
        name = messageArgs?.name.toString()

        detailViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        detailViewModel.getDetails()
        detailViewModel.loadDetails(id)

        tv_details.text = name.toString()
        Picasso.get().load("http://hospitalguideapi.dsv.hoz.mybluehost.me"+messageArgs?.image).into(hospitalImage)
    }

    override fun onResume() {
        super.onResume()
        var messageArgs = arguments?.let {
            DetailsFragmentArgs.fromBundle(it)
        }
        detailViewModel.loadDetails(id)
        tv_details.text = name.toString()
        Picasso.get().load("http://hospitalguideapi.dsv.hoz.mybluehost.me"+messageArgs?.image).into(hospitalImage)
    }
}