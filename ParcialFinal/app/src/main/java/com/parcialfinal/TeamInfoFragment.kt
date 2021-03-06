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
        if (args.teamName != null){
            binding.txtTeamName.text = args.teamName
        } else {
            Toast.makeText(context, "Name not available", Toast.LENGTH_SHORT).show()
        }

        if (args.teamDescription != null){
            binding.txtTeamDescription.text = args.teamDescription
        } else {
            Toast.makeText(context, "Description not available", Toast.LENGTH_SHORT).show()
        }

        if (args.badgeUrl != null){
            Picasso.get().load(args.badgeUrl).into(binding.imgTeamBadge)
        } else {
            Toast.makeText(context, "Badge not available", Toast.LENGTH_SHORT).show()
        }

        if (args.teamJersey != null){
            Picasso.get().load(args.teamJersey).into(binding.imgTeamJersey)
        } else {
            Toast.makeText(context, "Jersey not available", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
