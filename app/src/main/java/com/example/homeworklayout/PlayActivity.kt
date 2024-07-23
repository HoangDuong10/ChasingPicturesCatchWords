package com.example.homeworklayout
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.homeworklayout.databinding.ActivityMainBinding
import com.example.homeworklayout.viewmodel.PlayViewModel


class PlayActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var list = mutableListOf<String>()
    private lateinit var viewModel : PlayViewModel
    private var suggestButton : List<Button> = mutableListOf()
    private var resultButton : List<Button> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[PlayViewModel::class.java]
        onClickBtnNext()
        showNewQuestion()
        responseResult()
    }

    private fun responseResult(){
        viewModel.isResult.observe(this,Observer{
            if(it){
                binding.tvResult.visibility = View.VISIBLE
                binding.tvResult.text = "Bạn đã tìm ra đáp án!"
                binding.btnNext.visibility = View.VISIBLE
                binding.tvScores.text = (binding.tvScores.text.toString().toInt() + 100).toString()
                resultButton.forEach{button->
                    button.backgroundTintList = null
                    button.background = ContextCompat.getDrawable(this, R.drawable.ic_tile_true)
                }
            }else{
                binding.tvResult.visibility = View.VISIBLE
                binding.tvResult.text = "Bạn đã chọn sai đáp án rồi!"
                binding.btnNext.visibility = View.VISIBLE
                if(binding.tvScores.text.toString().toInt()>=100){
                    binding.tvScores.text = (binding.tvScores.text.toString().toInt() - 100).toString()
                }
                binding.tvNumberOfTimesPlayed.text = (binding.tvNumberOfTimesPlayed.text.toString().toInt() -1).toString()

                if(binding.tvNumberOfTimesPlayed.text.toString().toInt() == 0){
                    Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                    android.os.Handler(Looper.getMainLooper()).postDelayed({
                        finish()
                    }, 3000)


                }
                resultButton.forEach{button->
                    button.backgroundTintList = null
                    button.setTextColor(ContextCompat.getColor(this,R.color.white))
                    button.background = ContextCompat.getDrawable(this, R.drawable.ic_tile_false)
                }
            }
        })
    }

    private fun showNewQuestion(){
        viewModel.resultLiveData.observe(this, Observer { result ->
            binding.ivPicture.setImageResource(result.key)
            updateButtonResult(result.value.length)
            updateButtonSuggest(result.value.length,result)
        })
    }

    private fun onClickBtnNext(){
        binding.btnNext.setOnClickListener{
            viewModel.updateQuestion()
            suggestButton.forEach { button->
                button.visibility = View.VISIBLE
                button.isEnabled = true
            }
            resultButton.forEach {button->
                button.text = ""
                button.setTextColor(ContextCompat.getColor(this,R.color.black))
                button.backgroundTintList = ContextCompat.getColorStateList(this, R.color.grey)
            }
            binding.tvResult.visibility = View.GONE
            binding.btnNext.visibility = View.GONE
        }
    }

    private fun updateButtonResult(count: Int) {
        resultButton = listOf(binding.btnResult1,binding.btnResult2,binding.btnResult3,binding.btnResult4,
            binding.btnResult5,binding.btnResult6,binding.btnResult7,binding.btnResult8,binding.btnResult9,
            binding.btnResult10,binding.btnResult11,binding.btnResult12,binding.btnResult13,binding.btnResult14,
            binding.btnResult15,binding.btnResult16)

        resultButton.forEachIndexed { index, button ->
            if (index < count) {
                button.visibility = View.VISIBLE
            } else {
                button.visibility = View.GONE
            }
        }
    }


    private fun updateButtonSuggest(count: Int, map : Map.Entry<Int,String>) {
        suggestButton = listOf(
            binding.btnSuggest1, binding.btnSuggest2, binding.btnSuggest3, binding.btnSuggest4,
            binding.btnSuggest5, binding.btnSuggest6, binding.btnSuggest7, binding.btnSuggest8,
            binding.btnSuggest9, binding.btnSuggest10, binding.btnSuggest11, binding.btnSuggest12,
            binding.btnSuggest13, binding.btnSuggest14, binding.btnSuggest15, binding.btnSuggest16
        )

        val resultChars = map.value.toList()
        val allChars = "abcdefghijklmnopqrstuvwxyz".toList()
        val mixedChars = mutableListOf<Char>()
        mixedChars.addAll(resultChars)
        val remainingChars = allChars.minus(resultChars.toSet())
        // Nếu số ký tự còn lại không đủ 16 - resultChars.size thì lặp lại các ký tự còn lại
        while (mixedChars.size < 16) {
            mixedChars.add(remainingChars.random())
        }
        // Trộn ngẫu nhiên danh sách ký tự
        mixedChars.shuffle()
        var currentIndex = 0
        suggestButton.forEachIndexed { index, button ->
            button.text = mixedChars[index].toString()
            button.setOnClickListener {
                when (currentIndex) {
                    0 -> {
                        binding.btnResult1.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    1 -> {
                        binding.btnResult2.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    2 -> {
                        binding.btnResult3.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    3 -> {
                        binding.btnResult4.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    4 -> {
                        binding.btnResult5.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    5 -> {
                        binding.btnResult6.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    6 -> {
                        binding.btnResult7.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    7 -> {
                        binding.btnResult8.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    8 -> {
                        binding.btnResult9.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    9 -> {
                        binding.btnResult10.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    10 -> {
                        binding.btnResult11.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    11 -> {
                        binding.btnResult12.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    12 -> {
                        binding.btnResult13.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    13 -> {
                        binding.btnResult14.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    14 -> {
                        binding.btnResult15.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }

                    15 -> {
                        binding.btnResult16.text = button.text
                        button.visibility = View.INVISIBLE
                        list.add(button.text.toString())
                        checkResult(count,map)
                    }
                }
                currentIndex++
            }
        }
    }

    private fun checkResult(count: Int, map : Map.Entry<Int,String>){
        if(list.size==count){
            viewModel.updateIsResult(list,map)
            list.clear()
            suggestButton.forEach { button->
                button.isEnabled = false
            }
        }


    }

}