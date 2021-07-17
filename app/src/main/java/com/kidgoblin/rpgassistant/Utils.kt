package com.kidgoblin.rpgassistant

import android.content.Context
import android.provider.DocumentsContract
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.kidgoblin.rpgassistant.models.Character
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.nio.charset.StandardCharsets


class Utils {
    companion object {
        public fun getCharacters(context: Context): ArrayList<Character> {
            val listType = object : TypeToken<ArrayList<Character>>() {}.type
            val gson = GsonBuilder().create()
            val inputStream: InputStream = context.getResources().openRawResource(R.raw.sample_characters)
            val reader: Reader = InputStreamReader(inputStream, StandardCharsets.UTF_8)
            return gson.fromJson(reader, listType)
        }

    }
}