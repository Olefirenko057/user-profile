package com.practice.user_profile.controller

import com.practice.user_profile.domain.dto.request.ProfileRequest
import com.practice.user_profile.domain.dto.request.ProfileUpdateRequest
import com.practice.user_profile.domain.dto.response.ProfileResponse
import com.practice.user_profile.service.ImageService
import com.practice.user_profile.service.ProfileService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/profiles")
class ProfileController(
    private val profileService: ProfileService,
    ) {

    @GetMapping("/{id}")
    fun getProfileById(@PathVariable id: Long) : ResponseEntity<ProfileResponse> {
        return ResponseEntity(profileService.returnFoundProfileResponse(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    fun updateProfile(
        @PathVariable id: Long,
        @RequestBody @Valid profileUpdateRequest: ProfileUpdateRequest) : ResponseEntity<ProfileResponse>
    {
        return ResponseEntity(
            profileService.updateProfile(id,profileUpdateRequest),
            HttpStatus.OK)
    }

    @PostMapping("/upload-avatar/{id}")
    fun updateProfileAvatar(@PathVariable id: Long, @RequestParam("file") file: MultipartFile) : ResponseEntity<String> {
        return ResponseEntity(
            profileService.updateProfileAvatar(id,file),
            HttpStatus.OK)
    }

    @PostMapping
    fun createProfile(@RequestBody @Valid profileRequest: ProfileRequest) : ResponseEntity<ProfileResponse> {
        return ResponseEntity(
            profileService.createProfile(profileRequest),
            HttpStatus.CREATED
        )
    }



}