package com.github.roroche.diagrams

import ch.ifocusit.plantuml.classdiagram.ClassDiagramBuilder
import com.github.roroche.classes.Classes
import java.io.File

class ClassDiagram(
    private val classes: Classes,
    private val builder: ClassDiagramBuilder
): Diagram {

    constructor(classes: Classes) : this(
        classes = classes,
        builder = ClassDiagramBuilder()
    )

    override fun asString(): String {
        return builder.addClasse(
            classes.list()
        ).build()
    }

    override fun print(file: File) {
        file.writeText(asString())
    }
}