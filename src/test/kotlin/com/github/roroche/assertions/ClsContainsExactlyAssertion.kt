package com.github.roroche.assertions

import com.github.roroche.classes.Classes
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

class ClsContainsExactlyAssertion(
    private val classes: Classes,
    private val expectedClasses: List<Class<out Any>>
) : Assertion {
    override fun check() {
        assertThat(
            classes.list()
        ).containsExactlyInAnyOrderElementsOf(
            expectedClasses
        )
    }
}