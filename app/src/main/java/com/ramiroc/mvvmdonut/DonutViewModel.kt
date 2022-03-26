package com.ramiroc.mvvmdonut

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DonutViewModel(val dao: DonutDao):ViewModel() {
    var newDonutAte=""
    private val donuts: LiveData<List<Donut>> = dao.getAll()
    val donutString = Transformations.map(donuts){
        donuts->formatDonut((donuts))
    }
    fun formatDonut(donuts:List<Donut>):String{
        return convertToString(donuts[0])


        /*return donuts.fold(""){
                str,item -> str + '\n' + convertToString(item)

        }*/


    }

    fun convertToString(donut:Donut):String{
        var str = "Donuts Ate: ${donut.donutAte}"
        //str += '\n'+ "Number Ate: ${donut.donutAte}"+ '\n'
        return str
    }

    fun addDonut(){
        viewModelScope.launch {
            val donut = Donut()
            donut.donutAte = newDonutAte
            dao.insert(donut)
        }
    }
}