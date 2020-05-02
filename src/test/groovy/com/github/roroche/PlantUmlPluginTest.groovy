package com.github.roroche

import com.github.roroche.assertions.FindTaskAssertion
import com.github.roroche.assertions.ProjectWithPluginAssertion
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class PlantUmlPluginTest {
    @Test
    void testPlantUmlPlugin() {
        final Project project = ProjectBuilder.builder().build()
        new ProjectWithPluginAssertion(
                project,
                "com.github.roroche.plantuml",
                List.of(
                        new FindTaskAssertion(
                                project,
                                "buildClassDiagram"
                        )
                )
        ).check()
    }
}
