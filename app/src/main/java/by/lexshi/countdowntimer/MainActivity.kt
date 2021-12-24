package by.lexshi.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.inputmethod.InputBinding
import androidx.core.graphics.red
import by.lexshi.countdowntimer.databinding.ActivityMainBinding
import kotlin.text.Typography.times

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener {
                startCountDownTimer(20000)
            }
        }
    }

    private fun startCountDownTimer(timeMillis: Long){
        timer?.cancel() // if(timer!= null) timer.cancel()
        timer = object : CountDownTimer(timeMillis, 1){
            override fun onTick(timeM: Long) {
                binding.textView.text = timeM.toString()
            }

            override fun onFinish() {
                binding.textView.text = "Finish"
            }

        }.start()

    }
}