package com.github.roroche.plantuml.classes

import com.github.roroche.examples.Car
import com.github.roroche.examples.Driver
import com.github.roroche.plantuml.assertions.ClsContainsExactlyAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

/**
 * [TestsSuite] to perform checks about [ClsFiltered].
 */
class ClsFilteredTest : TestsSuite(
    TestCase(
        "classes in package filtered contains less classes",
        ClsContainsExactlyAssertion(
            classes = ClsFiltered(
                origin = ClsInPackage(
                    packageName = "com.github.roroche.examples"
                ),
                ignored = ClsWithNames(
                    names = listOf(
                        "com.github.roroche.examples.Vehicle"
                    )
                )
            ),
            expectedClasses = listOf(
                Car::class.java,
                Driver::class.java
            )
        )
    )
)