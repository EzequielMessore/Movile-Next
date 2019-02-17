package br.com.ezequiel.architecturecomponents.seekbar

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import br.com.ezequiel.architecturecomponents.R
import kotlinx.android.synthetic.main.fragment_seek_bar.*

class SeekBarFragment : Fragment() {

    private lateinit var seekBarViewModel: SeekBarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_seek_bar, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { act ->
            seekBarViewModel = ViewModelProviders
                    .of(act)
                    .get(SeekBarViewModel::class.java)

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    seekBarViewModel.seekBarValue.takeIf { fromUser }?.value = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            })

            seekBarViewModel.seekBarValue.observe(this, Observer { value ->
                seekBar.progress = value ?: 0
            })
        }

    }

}
