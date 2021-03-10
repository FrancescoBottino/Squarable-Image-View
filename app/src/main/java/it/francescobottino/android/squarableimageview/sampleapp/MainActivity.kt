package it.francescobottino.android.squarableimageview.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import it.francescobottino.android.squarableimageview.SquarableImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val horImage = findViewById<SquarableImageView>(R.id.horizontal)
        findViewById<Button>(R.id.hor_width).setOnClickListener {
            horImage.squareOn = SquarableImageView.SquaringType.WIDTH
        }
        findViewById<Button>(R.id.hor_none).setOnClickListener {
            horImage.squareOn = SquarableImageView.SquaringType.NONE
        }
        findViewById<Button>(R.id.hor_height).setOnClickListener {
            horImage.squareOn = SquarableImageView.SquaringType.HEIGHT
        }


        val verImage = findViewById<SquarableImageView>(R.id.vertical)
        findViewById<Button>(R.id.ver_width).setOnClickListener {
            verImage.squareOn = SquarableImageView.SquaringType.WIDTH
        }
        findViewById<Button>(R.id.ver_none).setOnClickListener {
            verImage.squareOn = SquarableImageView.SquaringType.NONE
        }
        findViewById<Button>(R.id.ver_height).setOnClickListener {
            verImage.squareOn = SquarableImageView.SquaringType.HEIGHT
        }
    }
}