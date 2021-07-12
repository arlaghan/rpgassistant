package com.kidgoblin.rpgassistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kidgoblin.rpgassistant.MainActivity
import com.kidgoblin.rpgassistant.R
import com.kidgoblin.rpgassistant.databinding.FragmentCharacterViewBinding

class CharacterViewFragment : Fragment() {

    private var _binding: FragmentCharacterViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterViewBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()

        //Set the FAB to open character create
        val fab = (activity as MainActivity?)!!.findViewById<FloatingActionButton>(R.id.fab)
        //TODO set click handler for FAB
        fab.show()
    }

}