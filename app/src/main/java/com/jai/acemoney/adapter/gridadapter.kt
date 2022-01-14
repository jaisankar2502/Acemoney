package com.jai.acemoney.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.jai.acemoney.R
import com.jai.acemoney.model.griditem

class gridadapter(var requireContext: Context, var arrayList: ArrayList<griditem>) : BaseAdapter(),AdapterView.OnItemClickListener {
    override fun getCount(): Int {
    return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View= View.inflate(requireContext, R.layout.gridlayout,null)
        var image: ImageView =view.findViewById(R.id.image)
        var name: TextView = view.findViewById(R.id.name)
        var listitem:griditem=arrayList.get(position)
        name.text=listitem.name
        listitem.image?.let { image.setImageResource(it) }
        return view
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }
}