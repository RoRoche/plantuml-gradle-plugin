package com.github.roroche.diagrams

import java.io.File

class PrintedDiagram(
    private val diagram: Diagram,
    private val file: File
) {
    fun file(): File {
        diagram.print(file)
        return file
    }
}