package com.example.simpleaudioplayer.fragments.player_content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simpleaudioplayer.databinding.FragmentPlayerContentBinding
import com.example.simpleaudioplayer.fragments.player_content.adapter.TrackAdapter
import com.example.simpleaudioplayer.fragments.player_content.screen_state.PlayerContentScreenState
import com.example.simpleaudioplayer.fragments.player_content.view_model.PlayerContentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerContentFragment : Fragment() {
    private val viewModel: PlayerContentViewModel by viewModel()

    private var _binding: FragmentPlayerContentBinding? = null
    private val binding: FragmentPlayerContentBinding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.screenState.observe(viewLifecycleOwner) { screenState ->
            when (screenState) {
                is PlayerContentScreenState.Loading -> { }
                is PlayerContentScreenState.Error -> { }
                is PlayerContentScreenState.Content -> {
                    binding.contentList.adapter = TrackAdapter(screenState.content)
                }
            }
        }

        binding.contentList.adapter = TrackAdapter()

        binding.addButton // button to open contentProvider and add another music in list

        binding.playerContainer // player fragment that is visible when player in state prepared


    }

    fun configureContentResolver() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}