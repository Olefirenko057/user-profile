package com.practice.user_profile.service

import com.practice.user_profile.domain.Profile
import com.practice.user_profile.domain.dto.request.ProfileRequest
import com.practice.user_profile.domain.dto.request.ProfileUpdateRequest
import com.practice.user_profile.domain.dto.response.ProfileResponse
import org.springframework.web.multipart.MultipartFile

interface ProfileService {
   fun returnFoundProfileResponse(id: Long) : ProfileResponse
   fun getProfileById(id: Long): Profile
   fun createProfile(profileRequest: ProfileRequest) : ProfileResponse
   fun updateProfile(id: Long,profileUpdateRequest: ProfileUpdateRequest): ProfileResponse
   fun updateProfileAvatar(id: Long, file: MultipartFile) : String
}