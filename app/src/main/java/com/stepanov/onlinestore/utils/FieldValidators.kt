package com.stepanov.onlinestore.utils

import java.util.regex.Pattern

fun String.isStringContainCyrillic(): Boolean {
    val cyrillicPattern = Pattern.compile("[а-яА-Я]*")
    val cyrillicPatternMatcher = cyrillicPattern.matcher(this)
    return cyrillicPatternMatcher.matches()
}