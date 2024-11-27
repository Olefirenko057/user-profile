package com.practice.user_profile.domain
import jakarta.persistence.*

@Entity
@Table(name = "profiles")
data class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    val id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "surname")
    var surname: String,

    @Column(name = "job_title")
    var jobTitle: String?,

    @Column(name = "phone")
    var phone: String,

    @Column(name = "address")
    var address: String?,

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "profile_interests", joinColumns = [JoinColumn(name = "id")])
    var interests: Set<String>?,

    @Column(name = "is_public")
    var isPublic: Boolean,

    @Column(name = "avatar_url")
    var avatarUrl: String? = null,

    @Column(name = "profile_link")
    val profileLink: String?
) {
}