package com.practice.user_profile.domain.dto.request

import com.practice.user_profile.domain.enums.ProfileVisibility
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class ProfileUpdateRequest(
    @field:Size(min = 2, max = 50,
        message = "Invalid name content length. 2-50 characters are allowed"
    )
    @field:Pattern(regexp = "^[A-Z][a-z]*(-?[A-Z][a-z]*)*$",
        message = "Wrong name format. Must be capitalised and contain letters and hyphens only")
    var name: String?,

    @field:Size(min = 2, max = 50,
        message = "Invalid surname length. 2-50 characters are allowed")
    @field:Pattern(regexp = "^[A-Z][a-z]*(-?[A-Z][a-z]*)*$",
        message = "Wrong surname format. Must be capitalised and contain letters and hyphens only")
    var surname: String?,

    @field:Size(max = 100,
        message = "Invalid job title length. Max of 100 characters are allowed")
    @field:Pattern(regexp = "^[A-Z][a-zA-Z\\s-]*$")
    var jobTitle: String?,

    @field:Pattern(regexp = "^[+]\\d{1,3}\\d{9,12}$",
        message = "Wrong phone number format. Must begin with '+' and be followed by 10-15 digits")
    var phone: String?,

    @field:Size(max = 200,
        message = "Invalid address length. Max of 200 characters are allowed")
    @field:Pattern(regexp = "^[a-zA-Z0-9,.\\s-]+$",
        message = "Wrong address format. Only letters, digits, commas, periods, hyphens, and spaces are allowed"
    )
    var address: String?,

    @field:Size(max = 10,
        message = "Max of 10 tags are allowed")
    var interests: Set<@Pattern(
        regexp = "^[a-zA-Z\\d\\s,.-]{1,30}$",
        message = "Wrong interest title format. " +
                "Max of 30 characters are allowed and must contain letters, digits, commas, hyphens, periods and spaces only"
    )String>?,

    @field:Size(max = 200,
        message = "Max of 200 characters are allowed")
    @field:Pattern(regexp = "^(http://|https://).*$",
        message = "The link must begin with either http:// or https://")
    var profileLink: String?,

    var profileVisibility: ProfileVisibility = ProfileVisibility.PRIVATE
) {
}