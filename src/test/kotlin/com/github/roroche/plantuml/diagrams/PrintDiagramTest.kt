package com.github.roroche.plantuml.diagrams

import com.github.roroche.plantuml.assertions.KtFileHasContentAssertion
import com.github.roroche.plantuml.classes.ClsInPackage
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

/**
 * [TestsSuite] to perform checks about printing [ClassDiagram].
 */
class PrintDiagramTest : TestsSuite(
    TestCase(
        "assert Diagram content is printed to file",
        KtFileHasContentAssertion(
            diagram = ClassDiagram(
                classes = ClsInPackage(
                    packageName = "com.github.roroche.examples"
                )
            ),
            file = tmpDirPath.resolve("output.txt").toFile(),
            expectedContent = """
                @startuml

                class "Car" {
                  brand : String
                  model : String
                  driver : Driver
                }

                class "Driver" {
                  name : String
                  cars : List<Car>
                }

                interface "Vehicle"

                "Car" "*" <-> "Driver" : driver/cars
                "Vehicle" <|-- "Car"

                @enduml
            """.trimIndent()
        )
    )
) {
    companion object TmpDir {
        @TempDir
        lateinit var tmpDirPath: Path
    }
}