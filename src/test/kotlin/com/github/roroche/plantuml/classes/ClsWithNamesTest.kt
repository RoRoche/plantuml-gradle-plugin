package com.github.roroche.plantuml.classes

import com.github.roroche.examples.Car
import com.github.roroche.examples.Driver
import com.github.roroche.examples.Vehicle
import com.github.roroche.plantuml.assertions.ClsContainsExactlyAssertion
import com.github.roroche.plantuml.assertions.ClsIsEmptyAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

/**
 * [TestsSuite] to perform checks about [ClsWithNames].
 */
class ClsWithNamesTest : TestsSuite(
    TestCase(
        "classes with names contains concrete classes",
        ClsContainsExactlyAssertion(
            classes = ClsWithNames(
                names = listOf(
                    "com.github.roroche.examples.Car",
                    "com.github.roroche.examples.Driver",
                    "com.github.roroche.examples.Vehicle"
                )
            ),
            expectedClasses = listOf(
                Car::class.java,
                Driver::class.java,
                Vehicle::class.java
            )
        )
    ),
    TestCase(
        "classes with empty names returns empty list",
        ClsIsEmptyAssertion(
            classes = ClsWithNames(
                names = emptyList()
            )
        )
    ),
    TestCase(
        "classes with null names returns empty list",
        ClsIsEmptyAssertion(
            classes = ClsWithNames(
                names = null
            )
        )
    )
)