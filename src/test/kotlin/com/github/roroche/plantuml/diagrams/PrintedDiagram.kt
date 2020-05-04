package com.github.roroche.plantuml.diagrams

import java.io.File

/**
 * Convenient class that prints [Diagram] into [File].
 *
 * @property diagram The [Diagram] to print.
 * @property file The [File] where to print.
 */
class PrintedDiagram(
    private val diagram: Diagram,
    private val file: File
) {
    /**
     * @return The [File] after printing the [Diagram].
     */
    fun file(): File {
        diagram.print(file)
        return file
    }
}