package com.github.roroche

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PlantUmlPluginTest {
    @Test
    fun plantUmlPluginTest() {
        val project: Project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.github.roroche.plantuml")
        assertTrue(
            project.pluginManager.hasPlugin("com.github.roroche.plantuml")
        )
        assertNotNull(
            project.tasks.getByName("buildClassDiagram")
        )
    }
}