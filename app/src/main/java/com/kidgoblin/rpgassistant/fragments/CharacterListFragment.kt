package com.kidgoblin.rpgassistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kidgoblin.rpgassistant.MainActivity
import com.kidgoblin.rpgassistant.R
import com.kidgoblin.rpgassistant.Utils
import com.kidgoblin.rpgassistant.adapters.CharacterListAdapter
import com.kidgoblin.rpgassistant.databinding.FragmentCharacterListBinding
import com.kidgoblin.rpgassistant.models.Character

class CharacterListFragment : Fragment() {
    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!
    private var characterList = ArrayList<Character>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
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
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_CharacterListFragment_to_CharacterCreateFragment)
        }
        fab.show()

        //Display the character list
        characterList = Utils.getCharacters(requireContext())
        binding.characterList.adapter = CharacterListAdapter(requireContext(), characterList)
        binding.characterList.layoutManager = LinearLayoutManager(requireContext())

        if (characterList.size == 0) {
            //No characters, show the placeholder text
            binding.message.visibility = View.VISIBLE
        } else {
            //Some characters present, show list
            binding.characterList.visibility = View.VISIBLE
        }
    }

}