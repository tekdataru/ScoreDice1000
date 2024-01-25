package ru.tekdata.scoredice1000

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.core.text.set
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
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

        binding.scorePlayer1.addTextChangedListener { binding.scorePlayer1Upsidedown.setText(binding.scorePlayer1.text) }
        binding.scorePlayer2.addTextChangedListener { binding.scorePlayer2Upsidedown.setText(binding.scorePlayer2.text) }
        binding.scorePlayer3.addTextChangedListener { binding.scorePlayer3Upsidedown.setText(binding.scorePlayer3.text) }
        binding.scorePlayer4.addTextChangedListener { binding.scorePlayer4Upsidedown.setText(binding.scorePlayer4.text) }
        binding.scorePlayer5.addTextChangedListener { binding.scorePlayer5Upsidedown.setText(binding.scorePlayer5.text) }
        binding.scorePlayer6.addTextChangedListener { binding.scorePlayer6Upsidedown.setText(binding.scorePlayer6.text) }

        binding.scorePlayer1.setOnClickListener{
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.scorePlayer1.windowToken, 0)
        }

        binding.buttonHideEmptyPlayers.setOnClickListener{
            var vv = LinearLayout.VISIBLE

            if (binding.buttonHideEmptyPlayers.text.equals("Скрыть")) {
                binding.buttonHideEmptyPlayers.setText("Показать")
                vv = LinearLayout.GONE
            } else binding.buttonHideEmptyPlayers.setText("Скрыть")

            if (binding.namePlayer1.text.isEmpty()) {binding.linearPlayer1.visibility = vv}
            if (binding.namePlayer2.text.isEmpty()) {binding.linearPlayer2.visibility = vv}
            if (binding.namePlayer3.text.isEmpty()) {binding.linearPlayer3.visibility = vv}
            if (binding.namePlayer4.text.isEmpty()) {binding.linearPlayer4.visibility = vv}
            if (binding.namePlayer5.text.isEmpty()) {binding.linearPlayer5.visibility = vv}
            if (binding.namePlayer6.text.isEmpty()) {binding.linearPlayer6.visibility = vv}


        }

        binding.scorePlayer1.setOnClickListener{
//            val view:View? = this.getCurrentFocus();
//            if (view != null) {
//                val imm:InputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//            }
        }

        binding.buttonSettings.setOnClickListener{
            if (binding.layoutSettings.visibility == LinearLayout.GONE)
                binding.layoutSettings.visibility = LinearLayout.VISIBLE
            else binding.layoutSettings.visibility = LinearLayout.GONE
        }

        binding.buttonLargeButtonsNumbers.setOnClickListener {

            val button = binding.buttonLargeButtonsNumbers;
            var widthInPixels:Int = 150
            var heightInPixels:Int = 150



            if (button.text.equals("Кнопки +")) {
                button.setText("Кнопки -")
                widthInPixels = (binding.button0.width * 1.5).toInt()
                heightInPixels = (binding.button0.height * 1.5).toInt()
            } else {
                button.setText("Кнопки +")
                widthInPixels = (binding.button0.width / 1.5).toInt()
                heightInPixels = (binding.button0.height / 1.5).toInt()
            }

            buttonSetLayoutParams(binding.button0, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button1, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button2, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button3, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button4, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button5, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button6, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button7, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button8, widthInPixels, heightInPixels)
            buttonSetLayoutParams(binding.button9, widthInPixels, heightInPixels)
        }

        binding.buttonColorsForPlayers.setOnClickListener {
            val button = binding.buttonColorsForPlayers;

            if (button.text.equals("Цвета +")) {
                button.setText("Цвета -")

                binding.namePlayer2.setTextColor(android.graphics.Color.BLUE)
                binding.namePlayer3.setTextColor(android.graphics.Color.RED)
                binding.namePlayer4.setTextColor(android.graphics.Color.GREEN)
                binding.namePlayer5.setTextColor(android.graphics.Color.YELLOW)
                binding.namePlayer6.setTextColor(android.graphics.Color.MAGENTA)

                binding.scorePlayer2.setTextColor(android.graphics.Color.BLUE)
                binding.scorePlayer3.setTextColor(android.graphics.Color.RED)
                binding.scorePlayer4.setTextColor(android.graphics.Color.GREEN)
                binding.scorePlayer5.setTextColor(android.graphics.Color.YELLOW)
                binding.scorePlayer6.setTextColor(android.graphics.Color.MAGENTA)

                binding.scorePlayer2Upsidedown.setTextColor(android.graphics.Color.BLUE)
                binding.scorePlayer3Upsidedown.setTextColor(android.graphics.Color.RED)
                binding.scorePlayer4Upsidedown.setTextColor(android.graphics.Color.GREEN)
                binding.scorePlayer5Upsidedown.setTextColor(android.graphics.Color.YELLOW)
                binding.scorePlayer6Upsidedown.setTextColor(android.graphics.Color.MAGENTA)
            } else {
                button.setText("Цвета +")

                val defColor = binding.scorePlayer1.textColors.defaultColor

                binding.namePlayer2.setTextColor(defColor)
                binding.namePlayer3.setTextColor(defColor)
                binding.namePlayer4.setTextColor(defColor)
                binding.namePlayer5.setTextColor(defColor)
                binding.namePlayer6.setTextColor(defColor)

                binding.scorePlayer2.setTextColor(defColor)
                binding.scorePlayer3.setTextColor(defColor)
                binding.scorePlayer4.setTextColor(defColor)
                binding.scorePlayer5.setTextColor(defColor)
                binding.scorePlayer6.setTextColor(defColor)

                binding.scorePlayer2Upsidedown.setTextColor(defColor)
                binding.scorePlayer3Upsidedown.setTextColor(defColor)
                binding.scorePlayer4Upsidedown.setTextColor(defColor)
                binding.scorePlayer5Upsidedown.setTextColor(defColor)
                binding.scorePlayer6Upsidedown.setTextColor(defColor)
            }
        }


    }



    private fun buttonNumberOnClick(buttonNumber: Button) {
        val v:View? = currentFocus

        if (v is EditText) {
            val editTemp:EditText = (v as EditText)
            editTemp.setText("" + editTemp.text + buttonNumber.text)
            editTemp.setSelection(editTemp.length())
        }
    }

    private fun buttonSetLayoutParams(buttonNumber: Button, widthInPixels: Int, heightInPixels: Int) {
        val layoutParams = buttonNumber.layoutParams
        layoutParams.width = widthInPixels // in pixels
        layoutParams.height = heightInPixels // in pixels
        buttonNumber.layoutParams = layoutParams
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
