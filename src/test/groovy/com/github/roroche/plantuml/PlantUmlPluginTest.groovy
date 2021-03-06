package com.github.roroche.plantuml

import com.github.roroche.plantuml.assertions.FindTaskAssertion
import com.github.roroche.plantuml.assertions.ProjectWithPluginAssertion
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
                                Arrays.asList(
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
