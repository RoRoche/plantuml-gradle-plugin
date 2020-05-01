package com.github.roroche.diagrams

import java.io.File

interface Diagram {

    fun asString(): String

    fun print(file: File)
}