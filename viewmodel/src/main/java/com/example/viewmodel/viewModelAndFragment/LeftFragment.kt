package com.example.viewmodel.viewModelAndFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentLeftBinding

class LeftFragment : Fragment() {


    private val viewModel: BlankViewModel by activityViewModels()
    private lateinit var viewBinding: FragmentLeftBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentLeftBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnTest.setOnClickListener {
            viewModel.addOne()
        }

        activity?.let { it ->
            viewModel.getLiveData().observe(it) {
                viewBinding.tvTest.text = it.toString()
            }
        }
    }


}