package br.com.movilenext.databinding

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.movilenext.databinding.databinding.ActivityGameInfoBinding
import br.com.movilenext.databinding.utils.contentView
import kotlinx.android.synthetic.main.activity_game_info.*

class GameInfoActivity : AppCompatActivity() {

    private val binding: ActivityGameInfoBinding by contentView(R.layout.activity_game_info)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_info)

        val game = Game(
                name = "Donkey Kong",
                launchYear = 1981,
                imageUrl = "https://vignette.wikia.nocookie.net/liberproeliis/images" +
                        "/2/2d/DKMP8.png/revision/latest/scale-to-width-down/400?cb=" +
                        "20161011111445&path-prefix=pt-br",
                rating = 5.0
        )
        binding.game = game

        tvRating.setOnClickListener {
            //game.rating++
        }
    }
}
