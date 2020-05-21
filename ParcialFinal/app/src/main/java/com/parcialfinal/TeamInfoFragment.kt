package com.parcialfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.parcialfinal.databinding.FragmentTeamInfoBinding

class TeamInfoFragment : Fragment() {
    lateinit var  binding: FragmentTeamInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_info, container, false)
        return binding.root
    }

}
