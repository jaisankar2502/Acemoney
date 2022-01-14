package com.jai.acemoney.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.jai.acemoney.R

class About : Fragment() {

    val args: AboutArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view= inflater.inflate(R.layout.fragment_about, container, false)
        val imageView = view.findViewById<ImageView>(R.id.Actorimage)
        val textView = view.findViewById<TextView>(R.id.Actordetails)

        imageView.setImageResource(args.itemDetails.image!!)
        textView.text = args.itemDetails.name
        return view
    }
}