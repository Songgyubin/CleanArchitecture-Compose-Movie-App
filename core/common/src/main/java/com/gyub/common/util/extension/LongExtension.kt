package com.gyub.common.util.extension

/**
 * Long형에 대한 확장 함수
 *
 * @author   Gyub
 * @created  2024/03/18
 */

fun Long?.orDefault(defaultValue: Long = 0) =
    this ?: defaultValue