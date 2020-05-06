package com.github.roroche.plantuml

import com.github.roroche.plantuml.assertions.CreateTaskAssertion
import com.github.roroche.plantuml.assertions.CreatedTask
import com.github.roroche.plantuml.assertions.ExecuteTaskAssertion
import com.github.roroche.plantuml.assertions.GrvFileHasContentAssertion
import com.github.roroche.plantuml.tasks.ClassDiagramExtension
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
                                new CreatedTask(
                                        ProjectBuilder.builder().build(),
                                        "buildClassDiagramTask",
                                        MockBuildClassDiagramTask.class,
                                        new ClassDiagramExtension(
                                                "com.github.roroche.examples",
                                                tmpDirPath.resolve("output.txt").toFile(),
                                                List.of()
                                        )
                                ),
                                MockBuildClassDiagramTask.class
                        )
                ),
                new TestCase(
                        "test buildClassDiagramTask print diagram to file",
                        new ExecuteTaskAssertion(
                                new CreatedTask(
                                        ProjectBuilder.builder().build(),
                                        "buildClassDiagramTask",
                                        MockBuildClassDiagramTask.class,
                                        new ClassDiagramExtension(
                                                "com.github.roroche.examples",
                                                tmpDirPath.resolve("output.txt").toFile(),
                                                List.of()
                                        )
                                ),
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
