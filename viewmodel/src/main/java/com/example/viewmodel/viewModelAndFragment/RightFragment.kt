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


class RightFragment : Fragment() {

    //ViewModel + LiveData + lifecycle
    //MMVM + RETROFIT + PAGING3

    private val viewModel: BlankViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_right, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvTest = view.findViewById<TextView>(R.id.tv_test)

        view.findViewById<Button>(R.id.btn_add_one).apply {
            setOnClickListener {
                viewModel.addOne()
            }
        }

        activity?.let { it ->
            viewModel.getLiveData().observe(it) {
                tvTest.text = it.toString()
            }
        }
    }

}