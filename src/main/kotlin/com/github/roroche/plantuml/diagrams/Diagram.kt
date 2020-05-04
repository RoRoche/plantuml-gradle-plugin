package com.github.roroche.plantuml.diagrams

import java.io.File

/**
 * Class representing a PlantUML diagram.
 */
interface Diagram {

    /**
     * @return The content of the diagram.
     */
    fun content(): String

    /**
     * Print the content into the [File].
     *
     * @param file The [File] where to print content.
     */
    fun print(file: File)

    /**
     * Convenient class representing a simple diagram.
     *
     * @property content The content of the digram.
     */
    class Simple(
        private val content: String
    ): Diagram {
        /**
         * @return The content of the diagram.
         */
        override fun content() = content

        /**
         * Print the content into the [File].
         *
         * @param file The [File] where to print content.
         */
        override fun print(file: File) {
            file.writeText(content())
        }
    }

    /**
     * Convenient wrapper.
     *
     * @property delegate The delegate [Diagram].
     */
    abstract class Wrap(
        private val delegate: Diagram
    ) : Diagram by delegate
}