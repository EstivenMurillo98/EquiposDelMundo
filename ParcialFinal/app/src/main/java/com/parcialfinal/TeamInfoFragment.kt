package com.parcialfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.parcialfinal.databinding.FragmentTeamInfoBinding
import com.squareup.picasso.Picasso

class TeamInfoFragment : Fragment() {
    lateinit var  binding: FragmentTeamInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_info, container, false)
        val args = TeamInfoFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Este es tu equipo ${args.teamName}", Toast.LENGTH_SHORT).show()
        binding.txtTeamName.text = args.teamName
        binding.txtTeamDescription.text = args.teamDescription
        Picasso.get().load(args.badgeUrl).into(binding.imgTeamBadge)
        Picasso.get().load(args.teamJersey).into(binding.imgTeamJersey)
        return binding.root
    }

}
