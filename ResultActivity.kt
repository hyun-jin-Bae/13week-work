package com.example.selfproject10_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.example.selfproject10_2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    val imageField = arrayOf(
        R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
        R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
        R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val voteCount = intent.getIntArrayExtra("voteCount")
        val imgName = intent.getStringArrayExtra("imgName")

        // 최다 득표 찾기
        val maxIndex = voteCount!!.indices.maxBy { voteCount[it] }

        binding.tvTopName.text = imgName!![maxIndex]
        binding.ivTopImage.setImageResource(imageField[maxIndex])

        // 9개 리스트 출력
        for (i in voteCount.indices) {
            val row = LinearLayout(this)
            row.orientation = LinearLayout.HORIZONTAL

            val tv = TextView(this)
            tv.text = imgName[i]
            tv.layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)

            val rating = RatingBar(this, null, android.R.attr.ratingBarStyleSmall)
            rating.numStars = 5
            rating.stepSize = 1f
            rating.rating = voteCount[i].toFloat()
            rating.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            row.addView(tv)
            row.addView(rating)

            binding.resultLayout.addView(row)
        }

        binding.btnReturn.setOnClickListener { finish() }
    }
}
