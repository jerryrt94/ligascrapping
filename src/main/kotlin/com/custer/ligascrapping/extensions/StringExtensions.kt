package com.custer.ligascrapping.extensions

fun String.normalize(): String {
    return this.trim().replace("\\s+".toRegex(), " ")
}