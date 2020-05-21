package com.parcialfinal.model

import com.google.gson.annotations.SerializedName

data class SoccerTeam (
    //val strTeam : String?,
   // val strTeamBadge : String?
    @SerializedName("strTeam") val teamName : String?,
    @SerializedName("strTeamBadge") val badgeUrl : String?,
    @SerializedName("strStadium") val stadiumName : String?,
    @SerializedName("strDescriptionEN") val teamDescription : String?,
    @SerializedName("strTeamJersey") val teamJersey : String?
)