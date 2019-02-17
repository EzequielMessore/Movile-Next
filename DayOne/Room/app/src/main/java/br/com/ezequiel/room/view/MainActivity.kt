package br.com.ezequiel.room.view

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.ezequiel.room.R
import br.com.ezequiel.room.model.Word
import br.com.ezequiel.room.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = WordListAdapter(this)
        recyclerView.adapter = adapter

        wordViewModel =
                ViewModelProviders
                        .of(this)
                        .get(WordViewModel::class.java)

        wordViewModel.allWords.observe(this,
                Observer { words ->
                    words?.let {
                        adapter.words = it
                    }
                })


        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                val word = Word(it.getStringExtra(NewWordActivity.EXTRA_REPLY))
                wordViewModel.insert(word)
            }
        } else {
            toast(R.string.empty_not_saved)
        }
    }

    companion object {
        const val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    }
}
