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

/**
 * 소수점 첫째 자리까지의 문자열 반환
 *
 * @return 소수점 첫째 자리까지의 문자열
 */
fun Double?.formatToSingleDecimal(): String {
    this ?: "0"
    return String.format("%.1f", this)
}