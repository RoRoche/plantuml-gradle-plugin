package com.github.roroche

import com.github.roroche.classes.Classes
import com.github.roroche.classes.ClsFiltered
import com.github.roroche.classes.ClsInPackage
import com.github.roroche.classes.ClsWithNames
import com.github.roroche.diagrams.ClassDiagram
import com.github.roroche.diagrams.Diagram
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option
import java.io.File

class BuildClassDiagramTask : DefaultTask() {
    @get:Input
    @set:Option(
        option = "packageName",
        description = "The package where to scan classes to build the class diagram."
    )
    lateinit var packageName: String

    @get:OutputFile
    lateinit var outputFile: File
        private set

    @get:Optional
    @get:Input
    @set:Option(
        option = "ignoredClasses",
        description = "The classes to be ignored while building class diagram."
    )
    var ignoredClasses: List<String>? = null

    @Option(
        option = "outputFile",
        description = "The file where to write the build class diagram."
    )
    fun setOutputFile(outputFile: String) {
        this.outputFile = File(outputFile)
    }

    fun populateParam(params: BuildClassDiagramParams) {
        packageName = params.packageName!!
        outputFile = params.outputFile!!
        ignoredClasses = params.ignoredClasses
    }

    @TaskAction
    fun execute() {
        group = "documentation"
        description = "Build PlantUML class diagram for a given package."
        val classes: Classes = ClsFiltered(
            ClsInPackage(
                packageName
            ),
            ClsWithNames(
                ignoredClasses
            )
        )
        val diagram: Diagram = ClassDiagram(classes)
        diagram.print(outputFile)
    }
}