package com.jai.acemoney.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.jai.acemoney.R
import com.jai.acemoney.adapter.gridadapter
import com.jai.acemoney.model.griditem

class Home : Fragment(),AdapterView.OnItemClickListener{
    lateinit var  gridview:GridView
    private var arrayList:ArrayList<griditem> ?= null
    private var adapterview: gridadapter?=null
    lateinit var location:TextView
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_home, container, false)
        navController = findNavController()
        gridview= view.findViewById(R.id.Actorgridview)
        arrayList= ArrayList()
        arrayList=setdata()
        adapterview= gridadapter(requireContext(),arrayList!!)
        gridview.adapter = adapterview
        gridview.onItemClickListener=this

        return view
    }

    private fun setdata(): ArrayList<griditem> {
        var arrayList:ArrayList<griditem> = ArrayList()
        arrayList.add(griditem(R.drawable.img1," Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1," Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        arrayList.add(griditem(R.drawable.img1,"Robert Downey Jr."))
        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val action = arrayList?.get(position)?.let { HomeDirections.actionHome2ToAbout(it) }
        navController.navigate(action!!)


    }

}