package com.manya.alienssiaod

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.xml.transform.Templates

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val firstFloor = Floor("first", R.color.colorBlue, arrayOf("exit"))
    private val secondFloor = Floor("second", R.color.colorSilver, arrayOf("control point", "low light camera"))
    private val thirdFloor = Floor("third", R.color.colorGreen, arrayOf("medical laboratory"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        questionTextView.text = resources.getText(R.string.whatRoomColor)
        firstRadioButton.setBackgroundColor(with(resources) { getColor(R.color.colorBlue) })
        secondRadioButton.setBackgroundColor(with(resources) { this.getColor(R.color.colorSilver) })
        thirdRadioButton.setBackgroundColor(with(resources) { getColor(R.color.colorGreen) })

        firstRadioButton.setOnClickListener(this)
        secondRadioButton.setOnClickListener(this)
        thirdRadioButton.setOnClickListener(this)
    }

    override fun onClick(it: View?) {
        val button = it as RadioButton
        when(button.text){
            "blue" -> exit(firstFloor)
            "silver" -> exit(secondFloor)
            "green" -> exit(thirdFloor)
            "control point" -> showMap("CP")
            "low light camera" -> showMap("Camera")
            "medical laboratory" -> showMap("ML")
            "exit" -> showMap("E")
        }
        firstRadioButton.setBackgroundColor(Color.WHITE)
        secondRadioButton.setBackgroundColor(Color.WHITE)
        thirdRadioButton.setBackgroundColor(Color.WHITE)
    }

    private fun exit(floor : Floor){
        questionTextView.text = resources.getText(R.string.whatRoom)
        when(floor){
            firstFloor -> {
                firstRadioButton.text = floor.rooms[0]
                secondRadioButton.text = secondFloor.rooms[0]
                thirdRadioButton.text = thirdFloor.rooms[0]
            }
            secondFloor -> {
                firstRadioButton.text = floor.rooms[0]
                secondRadioButton.text = floor.rooms[1]
                thirdRadioButton.text = thirdFloor.rooms[0]
            }
            thirdFloor -> {
                firstRadioButton.text = floor.rooms[0]
                secondRadioButton.text = secondFloor.rooms[1]
                thirdRadioButton.text = firstFloor.rooms[0]
            }
        }
    }

    private fun showMap(room : String){
        firstRadioButton.visibility = View.GONE
        secondRadioButton.visibility = View.GONE
        thirdRadioButton.visibility = View.GONE
        when (room){
            "CP" -> questionTextView.text = resources.getText(R.string.exitFromCP)
            "Camera" -> questionTextView.text = resources.getText(R.string.exitFromCamera)
            "ML" -> questionTextView.text = resources.getText(R.string.exitFromML)
            "E" -> questionTextView.text = resources.getText(R.string.exitFromFF)
        }
    }
}
