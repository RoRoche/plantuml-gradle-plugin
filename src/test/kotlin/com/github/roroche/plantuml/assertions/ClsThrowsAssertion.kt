package com.github.roroche.plantuml.assertions

import com.github.roroche.plantuml.classes.Classes
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThatThrownBy

/**
 * Assertion that checks that [Classes] throws exception.
 *
 * @property classes The [Classes] to check.
 * @property expectedClass The [Exception] [Class] expected to be thrown.
 * @property expectedMessage The expected [Exception] message.
 */
class ClsThrowsAssertion(
    private val classes: Classes,
    private val expectedClass: Class<out Exception>,
    private val expectedMessage: String
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        assertThatThrownBy {
            classes.list()
        }.isInstanceOf(
            expectedClass
        ).hasMessageContaining(
            expectedMessage
        )
    }
}