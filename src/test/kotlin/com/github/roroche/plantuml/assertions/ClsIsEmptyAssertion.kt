package com.github.roroche.plantuml.assertions

import com.github.roroche.plantuml.classes.Classes
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

/**
 * Assertion that checks that [Classes] is empty.
 *
 * @property classes The [Classes] to check.
 */
class ClsIsEmptyAssertion(
    private val classes: Classes
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        assertThat(
            classes.list()
        ).isEmpty()
    }
}