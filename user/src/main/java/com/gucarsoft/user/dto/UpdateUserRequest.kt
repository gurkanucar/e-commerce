package com.gucarsoft.user.dto

data class UpdateUserRequest(
    val mail:String?,
    val firstName: String?,
    val lastName: String?,
    val middleName: String?,

    )