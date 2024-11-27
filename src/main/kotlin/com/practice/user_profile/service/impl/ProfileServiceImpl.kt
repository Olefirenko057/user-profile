package com.practice.user_profile.service.impl

import com.practice.user_profile.domain.Profile
import com.practice.user_profile.domain.dto.request.ProfileRequest
import com.practice.user_profile.domain.dto.request.ProfileUpdateRequest
import com.practice.user_profile.domain.dto.response.ProfileResponse
import com.practice.user_profile.exceptions.ProfileNotFoundException
import com.practice.user_profile.repository.ProfileRepository
import com.practice.user_profile.service.ImageService
import com.practice.user_profile.service.ProfileService
import com.practice.user_profile.toProfile
import com.practice.user_profile.toProfileResponse
import com.practice.user_profile.updateProfile
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ProfileServiceImpl(
    private val profileRepository: ProfileRepository,
    private val imageService: ImageService
    ) : ProfileService {

    override fun returnFoundProfileResponse(id: Long) : ProfileResponse {
        return getProfileById(id).toProfileResponse()
    }

    override fun createProfile(profileRequest: ProfileRequest) : ProfileResponse {
        return profileRepository.save(profileRequest.toProfile()).toProfileResponse()
    }

    override fun updateProfile(id: Long, profileUpdateRequest: ProfileUpdateRequest): ProfileResponse {
        val profile = getProfileById(id)
        profileUpdateRequest.updateProfile(profile)
        return profileRepository.save(profile).toProfileResponse()
    }

    override fun updateProfileAvatar(id: Long, file: MultipartFile) : String {
        val profile = getProfileById(id)
        val avatarUrl = imageService.uploadAvatar(file);
        profile.avatarUrl = avatarUrl
        profileRepository.save(profile)
        return avatarUrl
    }


    override fun getProfileById(id: Long): Profile {
        return profileRepository.findById(id).orElseThrow {
            throw ProfileNotFoundException("Profile with the id of $id was not found")
        }
    }


}