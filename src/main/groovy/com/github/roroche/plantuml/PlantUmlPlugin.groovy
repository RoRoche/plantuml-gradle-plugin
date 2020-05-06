package com.github.roroche.plantuml

import com.github.roroche.plantuml.tasks.BuildClassDiagramTask
import com.github.roroche.plantuml.tasks.ClassDiagramExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.UnknownTaskException

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
                BuildClassDiagramTask.class,
                classDiagramExtension
        )
        try {
            final Task javaCompile = project.getTasks().getByName("compileJava")
            buildClassDiagramTask.dependsOn(javaCompile)
        } catch (final UnknownTaskException ignored) {
            buildClassDiagramTask.getLogger().debug("Not a Java project")
        }
        try {
            final Task groovyCompile = project.getTasks().getByName("compileGroovy")
            buildClassDiagramTask.dependsOn(groovyCompile)
        } catch (final UnknownTaskException ignored) {
            buildClassDiagramTask.getLogger().debug("Not a Groovy project")
        }
        try {
            final Task kotlinCompile = project.getTasks().getByName("compileKotlin")
            buildClassDiagramTask.dependsOn(kotlinCompile)
        } catch (final UnknownTaskException ignored) {
            buildClassDiagramTask.getLogger().debug("Not a Kotlin project")
        }
    }
}
