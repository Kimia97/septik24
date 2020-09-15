package com.example.septik_24

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Dagslogg (
    var id: Int? = 0,
    var date: String? = "",
    var totalCubic: Int? = 0
)