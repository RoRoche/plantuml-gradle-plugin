package com.github.roroche.plantuml.assertions

import com.github.roroche.plantuml.classes.Classes
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

/**
 * Assertion that checks that [Classes] contains given [Class].
 *
 * @property classes The [Classes] to check.
 * @property expectedClasses The expected [Class].
 */
class ClsContainsExactlyAssertion(
    private val classes: Classes,
    private val expectedClasses: List<Class<out Any>>
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        assertThat(
            classes.list()
        ).containsExactlyInAnyOrderElementsOf(
            expectedClasses
        )
    }
}