package com.parcialfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.parcialfinal.adapter.TeamAdapter
import com.parcialfinal.databinding.ActivityMainBinding
import com.parcialfinal.model.TeamList
import com.parcialfinal.network.RetrofitInstance
import com.parcialfinal.network.SoccerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val retrofit = RetrofitInstance.getRetrofitInstance()
        val request = retrofit.create(SoccerService::class.java)
        val call = request.getAllTeams()

        call.enqueue(object : Callback<TeamList> {
            override fun onFailure(call: Call<TeamList>, t: Throwable) {
                Toast.makeText(applicationContext, "A ocurrido un error ${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<TeamList>, response: Response<TeamList>) {
                binding.recyclerView.apply {
                    setHasFixedSize(true)
                    adapter = TeamAdapter(response.body()!!.teams.take(10))
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        })
    }
}
