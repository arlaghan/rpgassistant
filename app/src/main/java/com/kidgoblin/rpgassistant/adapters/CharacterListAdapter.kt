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
        characters[position].image?.let { url ->
            Glide.with(context)
                .asBitmap()
                .load(url)
                .into(holder.characterPortraitView)
        }

        //Set the name, if present
        characters[position].name?.let { name ->
            holder.characterNameView.text = name

            holder.characterParent.setOnClickListener {
                Toast.makeText(
                    context,
                    name,
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        //Set the click listener

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