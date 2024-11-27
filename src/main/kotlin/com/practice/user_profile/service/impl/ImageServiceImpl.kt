package com.practice.user_profile.service.impl

import com.practice.user_profile.exceptions.InvalidFileExtensionException
import com.practice.user_profile.service.ImageService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileNotFoundException
import java.util.*

@Service
class ImageServiceImpl : ImageService {


    override fun uploadAvatar(file: MultipartFile) : String {
        if(file.isEmpty) {
            throw FileNotFoundException("File is empty!")
        }
        val mimeType = file.contentType
        if(mimeType != null &&
            listOf("image/jpeg","image/jpg","image/png").contains(mimeType.lowercase())) {
            val ext = "." + mimeType.split("/")[1]
            val uploadedFile = File(System.getProperty("user.dir") + "/" + UUID.randomUUID().toString() + ext)
            file.transferTo(uploadedFile)
            return uploadedFile.absolutePath
        }
        throw InvalidFileExtensionException("Invalid file extension. Must be .jpeg, .jpg or .png")
    }
}