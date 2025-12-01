package com.example.selfproject10_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.selfproject10_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val voteCount = IntArray(9)
    val imgId = arrayOf(
        R.id.pic1, R.id.pic2, R.id.pic3,
        R.id.pic4, R.id.pic5, R.id.pic6,
        R.id.pic7, R.id.pic8, R.id.pic9
    )

    val imgName = arrayOf(
        "독서하는 소녀", "꽃피는 모자 소녀", "부채를 든 소녀",
        "이레느 캉 단 베르양", "잠자는 소녀", "테라스의 두 자매",
        "피아노 레슨", "피아노 앞의 소녀들", "해변에서"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in imgId.indices) {
            val img = findViewById<ImageView>(imgId[i])
            img.setOnClickListener {
                voteCount[i]++
                Toast.makeText(this, "${imgName[i]} : ${voteCount[i]} 표", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("voteCount", voteCount)
            intent.putExtra("imgName", imgName)
            startActivity(intent)
        }
    }
}
