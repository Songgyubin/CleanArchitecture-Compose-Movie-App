package com.gyub.common.util.extension

/**
 * Double 형에 대한 확장 함수
 *
 * @author   Gyub
 * @created  2024/03/18
 */

/**
 * null이면 default Value 반환
 */
fun Double?.orDefault(defaultValue: Double = 0.0) =
    this ?: defaultValue