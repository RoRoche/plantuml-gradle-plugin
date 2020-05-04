package com.github.roroche.plantuml

import com.github.roroche.plantuml.tasks.ClassDiagramExtension
import com.github.roroche.plantuml.tasks.BuildClassDiagramTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Custom Gradle plugin to generate and print PlantUML diagrams.
 */
class PlantUmlPlugin implements Plugin<Project> {
    /**
     * Apply the tasks.
     *
     * @param project The [Project] to configure with the plugin.
     */
    @Override
    void apply(final Project project) {
        final ClassDiagramExtension classDiagramExtension = project.extensions.create(
                "classDiagram",
                ClassDiagramExtension.class
        )
        final BuildClassDiagramTask buildClassDiagramTask = project.tasks.create(
                "buildClassDiagram",
                BuildClassDiagramTask.class
        )
        buildClassDiagramTask.populateParam(classDiagramExtension)
    }
}
