package com.github.roroche.classes

import com.github.roroche.assertions.ClsContainsExactlyAssertion
import com.github.roroche.examples.Car
import com.github.roroche.examples.Driver
import com.github.roroche.examples.Vehicle
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

class ClsInPackageTest : TestsSuite(
    TestCase(
        "classes in package contains concrete classes",
        ClsContainsExactlyAssertion(
            classes = ClsInPackage(
                packageName = "com.github.roroche.examples"
            ),
            expectedClasses = listOf(
                Car::class.java,
                Driver::class.java,
                Vehicle::class.java
            )
        )
    )
)