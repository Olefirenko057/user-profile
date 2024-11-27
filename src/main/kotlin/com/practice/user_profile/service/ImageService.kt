package com.practice.user_profile.service

import com.practice.user_profile.domain.Profile
import org.springframework.web.multipart.MultipartFile

interface ImageService {
    fun uploadAvatar(file: MultipartFile) : String
}