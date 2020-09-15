package com.example.septik_24

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Dagslogg (
    var date: String? = "",
    var totalCubic: Int? = 0
)