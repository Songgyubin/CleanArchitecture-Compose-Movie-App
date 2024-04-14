package com.gyub.data.genre.model

import com.gyub.domain.genre.model.GenreEntity
import com.gyub.network.model.Genre

/**
 * Genre -> GenreEntity
 *
 * @author   Gyub
 * @created  2024/04/14
 */
fun Genre.toEntity(): GenreEntity {
    return GenreEntity(
        id = id,
        name = name
    )
}
