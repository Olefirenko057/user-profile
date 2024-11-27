package com.practice.user_profile.exceptions.exceptionHandler

import com.practice.user_profile.exceptions.InvalidFileExtensionException
import com.practice.user_profile.exceptions.ProfileNotFoundException
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConversionException
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.reflect.Field
import java.util.function.Consumer

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun handle(ex: ProfileNotFoundException) : ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handle(ex: InvalidFileExtensionException) : ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handle(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String?>> {
        val errorsMap = ex.bindingResult.allErrors.associate { error ->
            val field = (error as FieldError).field
            val message = error.defaultMessage
            field to message
        }
        return ResponseEntity(errorsMap,HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMessageConversionException::class)
    fun handle(ex: HttpMessageConversionException): ResponseEntity<Map<String, String>> {
        val message = "Invalid value for profileVisibility. Allowed values are: PUBLIC, PRIVATE."
        return ResponseEntity(mapOf("error" to message), HttpStatus.BAD_REQUEST)
    }
}