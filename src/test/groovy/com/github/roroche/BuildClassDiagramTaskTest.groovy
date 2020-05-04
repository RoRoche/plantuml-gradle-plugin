package com.github.roroche

import com.github.roroche.assertions.CreateTaskAssertion
import com.github.roroche.assertions.ExecuteBuildClassDiagramTaskAssertion
import com.github.roroche.assertions.GrvFileHasContentAssertion
import com.github.roroche.tasks.BuildClassDiagramTask
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.io.TempDir

import java.nio.file.Path

/**
 * TestsSuite that performs checks about BuildClassDiagramTask.
 */
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
                ),
                new TestCase(
                        "test buildClassDiagramTask print diagram to file",
                        new ExecuteBuildClassDiagramTaskAssertion(
                                ProjectBuilder.builder().build(),
                                tmpDirPath.resolve("output.txt").toFile(),
                                new GrvFileHasContentAssertion(
                                        tmpDirPath.resolve("output.txt").toFile(),
                                        "@startuml\n" +
                                                "\n" +
                                                "class \"Car\" {\n" +
                                                "  brand : String\n" +
                                                "  model : String\n" +
                                                "  driver : Driver\n" +
                                                "}\n" +
                                                "\n" +
                                                "class \"Driver\" {\n" +
                                                "  name : String\n" +
                                                "  cars : List<Car>\n" +
                                                "}\n" +
                                                "\n" +
                                                "interface \"Vehicle\"\n" +
                                                "\n" +
                                                "\"Car\" \"*\" <-> \"Driver\" : driver/cars\n" +
                                                "\"Vehicle\" <|-- \"Car\"\n" +
                                                "\n" +
                                                "@enduml".trim()
                                )
                        )
                )
        )
    }

    @TempDir
    public static Path tmpDirPath
}
