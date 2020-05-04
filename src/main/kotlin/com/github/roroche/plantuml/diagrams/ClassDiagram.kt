package com.github.roroche.plantuml.diagrams

import ch.ifocusit.plantuml.classdiagram.ClassDiagramBuilder
import com.github.roroche.plantuml.classes.Classes

/**
 * Class representing a PlantUML class diagram.
 *
 * @param delegate The delegate [Diagram].
 */
class ClassDiagram(
    delegate: Diagram
) : Diagram.Wrap(delegate) {

    /**
     * Secondary constructor that builds a [Diagram.Simple].
     *
     * @param classes The [Classes] to be scanned.
     * @param builder The [ClassDiagramBuilder] to build the class diagram.
     */
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

    /**
     * Secondary constructor with defaults args.
     *
     * @param classes The [Classes] to be scanned.
     */
    constructor(classes: Classes) : this(
        classes = classes,
        builder = ClassDiagramBuilder()
    )
}