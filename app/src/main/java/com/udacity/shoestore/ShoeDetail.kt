package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeViewModel


class ShoeDetail : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.buttonSave.setOnClickListener {

            if (viewModel.addNewShoe()) {

                it.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
                viewModel.resetInput()
            } else {
                Snackbar.make(
                    requireView(),
                    getString(R.string.validate_input),
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }

        }

        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetail_to_shoeList)
        )

        return binding.root
    }
}

