package com.github.roroche

import com.github.roroche.assertions.CreateTaskAssertion
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class BuildClassDiagramTaskTest {
    @Test
    void buildClassDiagramTaskTest() {
        final Project project = ProjectBuilder.builder().build()
        new CreateTaskAssertion(
                project,
                "buildClassDiagramTask",
                BuildClassDiagramTask.class
        ).check()
    }
}
