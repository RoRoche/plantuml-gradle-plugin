package com.github.roroche

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BuildClassDiagramTaskTest {
    @Test
    void buildClassDiagramTaskTest() {
        final Project project = ProjectBuilder.builder().build()
        final Task task = project.task('buildClassDiagramTask', type: BuildClassDiagramTask)

        Assertions.assertNotNull(task)
        Assertions.assertTrue(task instanceof BuildClassDiagramTask)
    }
}
