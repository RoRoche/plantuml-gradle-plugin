package com.github.roroche

import com.github.roroche.assertions.CreateTaskAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import org.gradle.testfixtures.ProjectBuilder

class BuildClassDiagramTaskTest extends TestsSuite {
    BuildClassDiagramTaskTest() {
        super(
                new TestCase(
                        "test buildClassDiagramTask",
                        new CreateTaskAssertion(
                                ProjectBuilder.builder().build(),
                                "buildClassDiagramTask",
                                BuildClassDiagramTask.class
                        )
                )
        )
    }
}
