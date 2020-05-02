package com.github.roroche

import com.github.roroche.assertions.FindTaskAssertion
import com.github.roroche.assertions.ProjectWithPluginAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

/**
 * TestsSuite to perform checks about PlantUmlPlugin.
 */
class PlantUmlPluginTest extends TestsSuite {
    PlantUmlPluginTest() {
        super(
                new TestCase(
                        "test applying PlantUmlPlugin declares buildClassDiagram task",
                        new ProjectWithPluginAssertion(
                                BuiltProject.instance.toProject(),
                                "com.github.roroche.plantuml",
                                List.of(
                                        new FindTaskAssertion(
                                                BuiltProject.instance.toProject(),
                                                "buildClassDiagram"
                                        )
                                )
                        )
                )
        )
    }
}
