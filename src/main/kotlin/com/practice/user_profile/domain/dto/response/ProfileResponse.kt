package com.practice.user_profile.domain.dto.response

data class ProfileResponse(
    var name: String,
    var surname: String,
    var jobTitle: String?,
    var phone: String,
    var address: String?,
    var interests: Set<String>?,
    var isPublic: Boolean,
    var avatarUrl: String?,
    val profileLink: String?
    ) {
}