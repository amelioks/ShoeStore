package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.shoe_item.view.*

class ShoeList : Fragment() {


    val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_shoe_list, container, false)

        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.shoeList.removeAllViews()
            for (shoe in it) {
                addingShoe(shoe.name)
            }}

        binding.buttonAddShoe.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeList_to_shoeDetail))

        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.listmenu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_logout ->
                findNavController().navigate(R.id.action_shoeList_to_login)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addingShoe(shoeName: String) {
        val item = layoutInflater.inflate(R.layout.shoe_item,null)
        item.shoe_item.text = shoeName

        binding.shoeList.addView(item.shoe_item)

    }

}