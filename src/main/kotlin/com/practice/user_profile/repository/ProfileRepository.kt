package com.practice.user_profile.repository

import com.practice.user_profile.domain.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile,Long> {
}