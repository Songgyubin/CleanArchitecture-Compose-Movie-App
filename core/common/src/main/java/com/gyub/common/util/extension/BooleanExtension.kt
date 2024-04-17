package com.gyub.common.util.extension

/**
 * Boolean형 확장 함수
 *
 * @author   Gyub
 * @created  2024/03/18
 */

/**
 * null이면 default Value 반환
 */
fun Boolean?.orDefault(defaultValue: Boolean = false) =
    this ?: defaultValue