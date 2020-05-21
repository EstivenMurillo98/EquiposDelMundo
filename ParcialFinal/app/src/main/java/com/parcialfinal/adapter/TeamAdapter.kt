package com.parcialfinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.parcialfinal.R
import com.parcialfinal.TeamItemFragmentDirections
import com.parcialfinal.databinding.TeamItemLayoutBinding
import com.parcialfinal.model.SoccerTeam
import com.squareup.picasso.Picasso

class TeamAdapter(val teamList: List<SoccerTeam>) : RecyclerView.Adapter<TeamAdapter.TeamHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TeamItemLayoutBinding>(layoutInflater, R.layout.team_item_layout, parent, false)
        return TeamHolder(binding)
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(teamList[position])
    }

    inner class TeamHolder(val binding: TeamItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(team: SoccerTeam){
            binding.txtTeamName.text = "Name: "+team.teamName
            binding.txtStadiumName.text = "Stadium: " + team.stadiumName
            Picasso.get().load(team.badgeUrl.toString()).into(binding.imgTeamBadge)
            binding.btnTeamDetails.setOnClickListener {
                it.findNavController().navigate(TeamItemFragmentDirections.actionTeamItemFragmentToTeamInfoFragment
                    (team.teamName, team.teamDescription, team.badgeUrl, team.teamJersey))
            }
        }
    }
}