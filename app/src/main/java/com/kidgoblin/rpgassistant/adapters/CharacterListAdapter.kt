package com.kidgoblin.rpgassistant.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kidgoblin.rpgassistant.R
import com.kidgoblin.rpgassistant.models.Character

class CharacterListAdapter(val context: Context, val characters: ArrayList<Character>) :
    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {
    private val TAG = "CharacterListAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.character_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder: position=$position")

        //Load the image from web, if present
        //TODO: Implement placeholder images
        characters[position].image?.let { uri ->
            //TODO: Pull from local storage instead
            Glide.with(context)
                .asBitmap()
                .load(uri)
                .into(holder.characterPortraitView)
        }

        //Set the name, if present
        characters[position].name?.let { name ->
            holder.characterNameView.text = name

            //TODO: Use a default name if not present
        }

        //Set the click listener
        //TODO: Key off of an ID instead of name
        characters[position].name?.let { name ->
            holder.characterParent.setOnClickListener {
                //TODO: Replace this with parameterized nav action
                Toast.makeText(
                    context,
                    name,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var characterParent: View = itemView.findViewById(R.id.character_parent)
        var characterPortraitView: ImageView = itemView.findViewById(R.id.character_portrait)
        var characterNameView: TextView = itemView.findViewById(R.id.character_name)
    }

}