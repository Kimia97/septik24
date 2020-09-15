package com.example.septik_24

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Test (
    var username: String = "",
    var email: String = ""
)