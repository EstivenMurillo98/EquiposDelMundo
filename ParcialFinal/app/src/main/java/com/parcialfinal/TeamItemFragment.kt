package com.parcialfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.parcialfinal.adapter.TeamAdapter
import com.parcialfinal.databinding.FragmentTeamItemBinding
import com.parcialfinal.model.TeamList
import com.parcialfinal.network.RetrofitInstance
import com.parcialfinal.network.SoccerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamItemFragment : Fragment() {
    lateinit var  binding: FragmentTeamItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_item, container, false)

        val retrofit = RetrofitInstance.getRetrofitInstance()
        val request = retrofit.create(SoccerService::class.java)
        val call = request.getAllTeams()

        call.enqueue(object : Callback<TeamList> {
            override fun onFailure(call: Call<TeamList>, t: Throwable) {
                Toast.makeText(context, "A ocurrido un error ${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<TeamList>, response: Response<TeamList>) {
                binding.recyclerView.apply {
                    setHasFixedSize(true)
                    adapter = TeamAdapter(response.body()!!.teams.take(10))
                    layoutManager = LinearLayoutManager(context)
                }
            }
        })
        return binding.root
    }
}
