package com.github.roroche

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Custom Gradle plugin to generate and print PlantUML diagrams.
 */
class PlantUmlPlugin : Plugin<Project> {
    /**
     * Apply the tasks.
     *
     * @param project The [Project] to configure with the plugin.
     */
    override fun apply(project: Project) {
        val buildClassDiagramParams = project.extensions.create(
            "buildClassDiagram",
            BuildClassDiagramExtension::class.java
        )
        val buildClassDiagramTask = project.tasks.create(
            "buildClassDiagram",
            BuildClassDiagramTask::class.java
        )
        buildClassDiagramTask.populateParam(buildClassDiagramParams)
    }
}