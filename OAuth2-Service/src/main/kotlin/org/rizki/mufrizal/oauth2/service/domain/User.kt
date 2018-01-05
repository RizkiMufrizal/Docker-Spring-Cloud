package org.rizki.mufrizal.oauth2.service.domain

import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Table

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 05 January 2018
 * @Time 21.16
 * @Project OAuth2-Service
 * @Package org.rizki.mufrizal.oauth2.service.domain
 * @File User
 *
 */

@Entity
@Table(name = "tb_user_oauth")
data class User(
        @Id
        @Column
        val username: String? = null,
        @Column
        val password: String? = null,
        @Column(name = "is_active")
        val isActive: Boolean? = null,
        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(name = "roles", joinColumns = [(JoinColumn(name = "username"))])
        @Column(name = "roles")
        val roles: Set<String>? = null
)