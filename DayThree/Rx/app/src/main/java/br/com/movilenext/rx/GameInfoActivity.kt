package br.com.movilenext.rx

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.movilenext.rx.ui.gameadd.GameAddActivity
import kotlinx.android.synthetic.main.activity_game_info.*

class GameInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_info)

        fabAdd.setOnClickListener {
            startActivity(Intent(this, GameAddActivity::class.java))
        }
    }
}
