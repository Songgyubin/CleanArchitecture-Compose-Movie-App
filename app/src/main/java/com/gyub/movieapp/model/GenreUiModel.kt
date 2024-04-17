package com.gyub.movieapp.model

import com.gyub.common.util.extension.orDefault
import com.gyub.domain.genre.model.GenreEntity

/**
 * 장르 UI Model
 *
 * @author   Gyub
 * @created  2024/04/14
 */
data class GenreUiModel(
    val id: Int = 0,
    val name: String = ""
)

/**
 * Mapper
 * [GenreEntity] to [GenreUiModel]
 *
 * @return [GenreUiModel]
 */
fun GenreEntity.toUiModel(): GenreUiModel {
    return GenreUiModel(
        id = id.orDefault(),
        name = name.orEmpty()
    )
}