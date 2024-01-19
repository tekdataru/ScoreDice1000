package ru.tekdata.scoredice1000

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
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

        var playerNumb:Int = 0
        var activeEditScore = binding.scorePlayer1
        var activeEditName = binding.namePlayer1
        var activeName = binding.namePlayer1.text

        binding.buttonSetAndGo.setOnClickListener {
            playerNumb++

            if (playerNumb > 6) playerNumb = 1

            //if (activeEditScore.text.isEmpty()) activeEditScore.setText("0")
            if (binding.editTempSum.text.isEmpty()) binding.editTempSum.setText("0")

            //activeEditScore.setText("" + (activeEditScore.text.toString().toInt() + binding.editTempSum.text.toString().toInt()).toString())
            activeEditScore.setText(binding.editTempSum.text.toString())
            if (!binding.editTempSum.text.toString().equals("") && !binding.editTempSum.text.toString().equals("0") )
            binding.editLastNumbers.setText("" + binding.editTempSum.text.toString() + ", " + binding.editLastNumbers.text.toString())

            //binding.editLastNumbers.setText("" + binding.editTempSum.text.toString() + ", " )
            if (activeEditScore.text.equals("0".toString())) activeEditScore.setText("")
            //activeEditScore.setBackgroundColor(0)
            activeEditName.setText(activeName)

            binding.editTempSum.setText("")

            //val editPlayerScore = getViewOfScoreByNumber(playerNumb)
            val editPlayerScore =
                if (playerNumb == 1) binding.scorePlayer1
                else if (playerNumb == 2) binding.scorePlayer2
                else if (playerNumb == 3) binding.scorePlayer3
                else if (playerNumb == 4) binding.scorePlayer4
                else if (playerNumb == 5) binding.scorePlayer5
                else binding.scorePlayer6

            val editPlayerName =
                if (playerNumb == 1) binding.namePlayer1
                else if (playerNumb == 2) binding.namePlayer2
                else if (playerNumb == 3) binding.namePlayer3
                else if (playerNumb == 4) binding.namePlayer4
                else if (playerNumb == 5) binding.namePlayer5
                else binding.namePlayer6



            //editPlayerScore.setBackgroundColor(5)

            activeEditScore = editPlayerScore
            activeEditName = editPlayerName

            activeName = activeEditName.text

            //editPlayerScore.setText("adfsdf")
            editPlayerName.setText("" + activeName + " --->")


            if (editPlayerName.text.toString().equals(" --->")) {
                editPlayerScore.setText("")
                activeEditScore.text.clear()
                binding.buttonSetAndGo.callOnClick()
            }
        }

        binding.button0.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button0.text)}
        binding.button1.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button1.text)}
        binding.button2.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button2.text)}
        binding.button3.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button3.text)}
        binding.button4.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button4.text)}
        binding.button5.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button5.text)}
        binding.button6.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button6.text)}
        binding.button7.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button7.text)}
        binding.button8.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button8.text)}
        binding.button9.setOnClickListener {binding.editTempSum.setText("" + binding.editTempSum.text + binding.button9.text)}

        binding.buttonX.setOnClickListener {binding.editTempSum.setText("0")}
        binding.buttonBackSpase.setOnClickListener {
            val ets = binding.editTempSum
            if (ets.text.isEmpty()) {return@setOnClickListener}
            ets.setText(ets.text.toString().substring(0, ets.text.length - 1))
        }



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
