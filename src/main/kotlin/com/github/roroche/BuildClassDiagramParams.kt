package com.github.roroche

import java.io.File

class BuildClassDiagramParams {
    var packageName: String? = null

    var outputFile: File? = null
        private set

    var ignoredClasses: List<String>? = null

    fun setOutputFile(outputFile: String) {
        this.outputFile = File(outputFile)
    }
}