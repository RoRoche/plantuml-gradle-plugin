package com.github.roroche.plantuml.diagrams

import com.github.roroche.plantuml.assertions.DiagramHasContentAssertion
import com.github.roroche.plantuml.classes.ClsFiltered
import com.github.roroche.plantuml.classes.ClsInPackage
import com.github.roroche.plantuml.classes.ClsWithNames
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

/**
 * [TestsSuite] to perform checks about [ClassDiagram].
 */
class ClassDiagramTest : TestsSuite(
    TestCase(
        "assert ClassDiagram for package com.github.roroche.examples build diagram properly",
        DiagramHasContentAssertion(
            diagram = ClassDiagram(
                classes = ClsInPackage(
                    packageName = "com.github.roroche.examples"
                )
            ),
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
    ),
    TestCase(
        "assert ClassDiagram for package com.github.roroche.examples without Vehicle build diagram properly",
        DiagramHasContentAssertion(
            diagram = ClassDiagram(
                classes = ClsFiltered(
                    origin = ClsInPackage(
                        packageName = "com.github.roroche.examples"
                    ),
                    ignored = ClsWithNames(
                        names = listOf(
                            "com.github.roroche.examples.Vehicle"
                        )
                    )
                )
            ),
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

                "Car" "*" <-> "Driver" : driver/cars

                @enduml
            """.trimIndent()
        )
    )
)