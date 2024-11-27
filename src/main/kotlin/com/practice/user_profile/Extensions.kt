package com.practice.user_profile

import com.practice.user_profile.domain.Profile
import com.practice.user_profile.domain.dto.request.ProfileRequest
import com.practice.user_profile.domain.dto.request.ProfileUpdateRequest
import com.practice.user_profile.domain.dto.response.ProfileResponse
import com.practice.user_profile.domain.enums.ProfileVisibility

fun ProfileRequest.toProfile() = Profile (
    name = this.name,
    surname = this.surname,
    jobTitle = this.jobTitle,
    phone = this.phone,
    address = this.address,
    interests = this.interests,
    profileLink = this.profileLink,
    isPublic = this.profileVisibility == ProfileVisibility.PUBLIC
)


fun Profile.toProfileResponse() = ProfileResponse (
    name = this.name,
    surname = this.surname,
    jobTitle = this.jobTitle,
    phone = this.phone,
    address = this.address,
    interests = this.interests,
    avatarUrl = this.avatarUrl,
    isPublic = this.isPublic,
    profileLink = this.profileLink
)


fun ProfileUpdateRequest.updateProfile(profile: Profile) {
     profile.apply {
         name = this@updateProfile.name ?: name
         surname = this@updateProfile.surname ?: surname
         jobTitle = this@updateProfile.jobTitle ?: jobTitle
         phone = this@updateProfile.phone ?: phone
         address = this@updateProfile.address ?: address
         interests = this@updateProfile.interests ?: interests
         isPublic = this@updateProfile.profileVisibility == ProfileVisibility.PUBLIC
     }
}
