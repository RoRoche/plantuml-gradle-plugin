package com.github.roroche

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

object BuildProject {
    private val project: Project = ProjectBuilder.builder().build()

    fun toProject() = project
}