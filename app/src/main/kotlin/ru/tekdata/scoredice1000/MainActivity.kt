package ru.tekdata.scoredice1000

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.text.set
import ru.tekdata.scoredice1000.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.namePlayer1.setText("Костя")
//      binding.namePlayer2.setText("Маша")
//      binding.namePlayer3.setText("Юля")
//      binding.namePlayer4.setText("Саня")
//      binding.namePlayer5.setText("Серега")
//      binding.namePlayer6.setText("Вика")


        binding.button0.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button1.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button2.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button3.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button4.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button5.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button6.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button7.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button8.setOnClickListener { buttonNumberOnClick((it as Button)) }
        binding.button9.setOnClickListener { buttonNumberOnClick((it as Button)) }




        binding.buttonBackSpaseScorePlayer1.setOnClickListener {clickBackSpaceForScore(binding.scorePlayer1)}
        binding.buttonBackSpaseScorePlayer2.setOnClickListener {clickBackSpaceForScore(binding.scorePlayer2)}
        binding.buttonBackSpaseScorePlayer3.setOnClickListener {clickBackSpaceForScore(binding.scorePlayer3)}
        binding.buttonBackSpaseScorePlayer4.setOnClickListener {clickBackSpaceForScore(binding.scorePlayer4)}
        binding.buttonBackSpaseScorePlayer5.setOnClickListener {clickBackSpaceForScore(binding.scorePlayer5)}
        binding.buttonBackSpaseScorePlayer6.setOnClickListener {clickBackSpaceForScore(binding.scorePlayer6)}


    }

    private fun buttonNumberOnClick(buttonNumber: Button) {
        val v:View? = currentFocus

        if (v is EditText) {
            val editTemp:EditText = (v as EditText)
            editTemp.setText("" + editTemp.text + buttonNumber.text)
            editTemp.setSelection(editTemp.length())
        }
    }
    private fun clickBackSpaceForScore(editTemp: EditText){
        editTemp.requestFocus()
        if (editTemp.text.isEmpty()) {
            editTemp.setSelection(editTemp.length())
            return
        }
        editTemp.setText(editTemp.text.toString().substring(0, editTemp.text.length - 1))
        editTemp.setSelection(editTemp.length())
    }


    private fun getViewOfScoreByNumber(playerNumb: Int): EditText {

        val binding = ActivityMainBinding.inflate(layoutInflater)

        val editPlayerScore =
            if (playerNumb == 1) binding.scorePlayer1
            else if (playerNumb == 2) binding.scorePlayer2
            else binding.scorePlayer3

        return editPlayerScore
    }

}
