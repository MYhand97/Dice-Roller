package com.myhand.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollBtn.setOnClickListener {
            rollDice()
        }
    }

    var dice by Delegates.notNull<Int>()

    private fun rollDice(){
        var hasil : Int = 0
        diceImage1.setImageResource(getRollDice())
        hasil += dice
        diceImage2.setImageResource(getRollDice())
        hasil += dice
        Toast.makeText(this, "Your Dice Is $hasil",
                Toast.LENGTH_LONG).show()
    }

    private fun getRollDice() : Int {
        val randomInt = (1..6).random()
        dice = randomInt
        return when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }
}
