package com.parcialfinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.parcialfinal.R
import com.parcialfinal.databinding.FragmentTeamInfoBinding
import com.parcialfinal.model.SoccerTeam
import com.squareup.picasso.Picasso

class InfoAdapter(val teamList: SoccerTeam) : RecyclerView.Adapter<InfoAdapter.TeamHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentTeamInfoBinding>(layoutInflater, R.layout.fragment_team_info, parent, false)
        return TeamHolder(binding)
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(teamList)
    }

    inner class TeamHolder(val binding: FragmentTeamInfoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(team: SoccerTeam){
            binding.txtTeamName.text = "Name: "+team.teamName
            binding.txtTeamDescription.text = "Stadium: " + team.stadiumName
            Picasso.get().load(team.badgeUrl).into(binding.imgTeamBadge)
            Picasso.get().load(team.teamJersey).into(binding.imgTeamJersey)
        }
    }

}