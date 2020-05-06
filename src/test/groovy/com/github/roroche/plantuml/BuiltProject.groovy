package com.github.roroche.plantuml

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

/**
 * Singleton class to hold a unique instance of Project.
 */
@Singleton
class BuiltProject {
    private final Project project = ProjectBuilder.builder().build()

    /**
     * @return The Project instance.
     */
    Project toProject() {
        project.sourceSets.main.output.classesDirs = project.buildDir.toPath().resolve("classes").resolve("java")
        return project
    }
}
