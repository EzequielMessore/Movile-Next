package br.com.ezequiel.room.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.ezequiel.room.R
import kotlinx.android.synthetic.main.activity_new_word.*

/**
 * Created by ezequiel.messore on 03/11/18.
 * ezequiel.messore@s2it.com.br
 */
class NewWordActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        btSave.setOnClickListener {
            val replyIntent = Intent()

            if (etWord.text.isEmpty()) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = etWord.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }

            finish()
        }
    }
}