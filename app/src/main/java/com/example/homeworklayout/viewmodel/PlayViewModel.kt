package com.example.homeworklayout.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworklayout.R
import com.example.homeworklayout.model.Result

class PlayViewModel : ViewModel() {


    val resultLiveData = MutableLiveData<Map.Entry<Int, String>>()
    val isResult = MutableLiveData<Boolean>()

    private val resultList = listOf(
        Result().apply { result = "aomua"; image = R.drawable.aomua },
        Result().apply { result = "baocao"; image = R.drawable.baocao },
        Result().apply { result = "canthiep"; image = R.drawable.canthiep },
        Result().apply { result = "cattuong"; image = R.drawable.cattuong },
        Result().apply { result = "chieutre"; image = R.drawable.chieutre },
        Result().apply { result = "danong"; image = R.drawable.danong },
        Result().apply { result = "giandiep"; image = R.drawable.giandiep },
        Result().apply { result = "giangmai"; image = R.drawable.giangmai },
        Result().apply { result = "hoidong"; image = R.drawable.hoidong },
        Result().apply { result = "hongtam"; image = R.drawable.hongtam },
        Result().apply { result = "khoailang"; image = R.drawable.khoailang },
        Result().apply { result = "kiemchuyen"; image = R.drawable.kiemchuyen },
        Result().apply { result = "lancan"; image = R.drawable.lancan },
        Result().apply { result = "masat"; image = R.drawable.masat },
        Result().apply { result = "nambancau"; image = R.drawable.nambancau },
        Result().apply { result = "oto"; image = R.drawable.oto },
        Result().apply { result = "quyhang"; image = R.drawable.quyhang },
        Result().apply { result = "songsong"; image = R.drawable.songsong },
        Result().apply { result = "thattinh"; image = R.drawable.thattinh },
        Result().apply { result = "thothe"; image = R.drawable.thothe },
        Result().apply { result = "tichphan"; image = R.drawable.tichphan },
        Result().apply { result = "danhlua"; image = R.drawable.danhlua },
        Result().apply { result = "tohoai"; image = R.drawable.tohoai },
        Result().apply { result = "totien"; image = R.drawable.totien },
        Result().apply { result = "tranhthu"; image = R.drawable.tranhthu },
        Result().apply { result = "vuaphaluoi"; image = R.drawable.vuaphaluoi },
        Result().apply { result = "vuonbachthu"; image = R.drawable.vuonbachthu },
        Result().apply { result = "xakep"; image = R.drawable.xakep },
        Result().apply { result = "xaphong"; image = R.drawable.xaphong },
        Result().apply { result = "xedapdien"; image = R.drawable.xedapdien },
    )

    private val resultMap = resultList.associate { it.image!! to it.result!! }
    private val entries = resultMap.entries.toList()
    init {
        updateQuestion()
    }

    fun updateQuestion() {
        resultLiveData.value = entries.random()
    }
    fun updateIsResult(listOfStrings: List<String>, mapEntry: Map.Entry<Int, String>){
        isResult.value = compareStringWithMapEntry(listOfStrings,mapEntry)
    }
fun compareStringWithMapEntry(listOfStrings: List<String>, mapEntry: Map.Entry<Int, String>) : Boolean {
        val mapValue = mapEntry.value // Lấy giá trị từ Map.Entry
        for (i in listOfStrings.indices) {
            val listChar = listOfStrings[i]
            val mapChar = mapValue[i].toString()

            if (listChar != mapChar) {
                return false
            }
        }
        return true
    }

}