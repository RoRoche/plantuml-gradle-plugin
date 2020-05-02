package com.github.roroche.diagrams

import com.github.roroche.assertions.FileHasContentAssertion
import com.github.roroche.classes.ClsInPackage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.IOException
import java.nio.file.Path

class WriteDiagramTest {
    @Test
    @Throws(IOException::class)
    fun testWriteContentToFile() {
        FileHasContentAssertion(
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
        ).check()
    }

    companion object TmpDir {
        @TempDir
        lateinit var tmpDirPath: Path
    }
}