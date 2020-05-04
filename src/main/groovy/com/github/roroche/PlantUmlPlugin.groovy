package com.github.roroche

import com.github.roroche.tasks.BuildClassDiagramExtension
import com.github.roroche.tasks.BuildClassDiagramTask
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
        final BuildClassDiagramExtension buildClassDiagramParams = project.extensions.create(
                "buildClassDiagram",
                BuildClassDiagramExtension.class
        )
        final BuildClassDiagramTask buildClassDiagramTask = project.tasks.create(
                "buildClassDiagram",
                BuildClassDiagramTask.class
        )
        buildClassDiagramTask.populateParam(buildClassDiagramParams)
    }
}
