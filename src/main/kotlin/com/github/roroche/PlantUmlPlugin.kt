package com.github.roroche

import org.gradle.api.Plugin
import org.gradle.api.Project

class PlantUmlPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        val buildClassDiagramParams = project.extensions.create(
            "buildClassDiagram",
            BuildClassDiagramParams::class.java
        )
        val buildClassDiagramTask = project.tasks.create(
            "buildClassDiagram",
            BuildClassDiagramTask::class.java
        )
        buildClassDiagramTask.populateParam(buildClassDiagramParams)
    }
}