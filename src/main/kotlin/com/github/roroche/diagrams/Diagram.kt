package com.github.roroche.diagrams

import java.io.File

interface Diagram {

    fun content(): String

    fun print(file: File)

    class Simple(
        private val content: String
    ): Diagram {
        override fun content() = content

        override fun print(file: File) {
            file.writeText(content())
        }
    }

    abstract class Wrap(
        private val delegate: Diagram
    ) : Diagram by delegate
}