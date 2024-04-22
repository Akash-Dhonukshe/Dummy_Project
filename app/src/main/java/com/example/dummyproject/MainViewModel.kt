package com.example.dummyproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dummyproject.data.RetrofitClient
import com.example.dummyproject.data.response.InformationItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var _user = MutableLiveData<List<InformationItem>>()

    val user : LiveData<List<InformationItem>>
        get() = _user

    init {
        getUsers()
    }



    fun getUsers() {
        val retrofitBuilder = RetrofitClient.getInstance()

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<InformationItem>?> {
            override fun onResponse(
                call: Call<List<InformationItem>?>,
                response: Response<List<InformationItem>?>
            ) {
                if(response.isSuccessful){
                    _user.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<InformationItem>?>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }
}