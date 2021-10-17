package com.ldev.newsfeed.feature.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBindings
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.FragmentMainscreenBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {

    private val viewModel by sharedViewModel<MainScreenViewModel>()

    //private val binding: FragmentMainscreenBinding by viewBinding(FragmentMainscreenBinding::bind )
   lateinit var binding: FragmentMainscreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainscreenBinding.inflate(layoutInflater)
        binding.button.setOnClickListener{
            viewModel.requestNews()
        }
        return binding.root//inflater.inflate(R.layout.fragment_mainscreen, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener{
            viewModel.requestNews()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
