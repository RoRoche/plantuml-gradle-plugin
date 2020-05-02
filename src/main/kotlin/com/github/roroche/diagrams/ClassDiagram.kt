package com.github.roroche.diagrams

import ch.ifocusit.plantuml.classdiagram.ClassDiagramBuilder
import com.github.roroche.classes.Classes

class ClassDiagram(
    delegate: Diagram
) : Diagram.Wrap(delegate) {

    constructor(
        classes: Classes,
        builder: ClassDiagramBuilder
    ) : this(
        Diagram.Simple(
            builder.addClasse(
                classes.list()
            ).build()
        )
    )

    constructor(classes: Classes) : this(
        classes = classes,
        builder = ClassDiagramBuilder()
    )
}