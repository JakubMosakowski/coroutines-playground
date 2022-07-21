package com.jakmos.coroutinesplayground.guide.shared.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jakmos.coroutinesplayground.databinding.FragmentCollectBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CollectFragment : Fragment() {

    private var _binding: FragmentCollectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: CollectViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCollectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.collect.setOnClickListener {
            viewModel.collect()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
