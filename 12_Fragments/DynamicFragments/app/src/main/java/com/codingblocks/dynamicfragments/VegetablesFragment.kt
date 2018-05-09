package com.codingblocks.dynamicfragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_vegetables.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class VegetablesFragment : Fragment() {

    val vegetables = arrayOf(
            "Potato", "Onion", "Tomato",
            "Lettuce", "Carrot", "Capsicum",
            "Gourd", "Pumpkin", "Radish"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val fragmentView = inflater.inflate(R.layout.fragment_vegetables, container, false)
        fragmentView.lvVegetables.adapter = ArrayAdapter<String>(
                context,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                vegetables
        )
        return fragmentView
    }


}
