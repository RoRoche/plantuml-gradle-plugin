package com.github.roroche.plantuml.assertions

import com.github.roroche.plantuml.diagrams.Diagram
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

/**
 * Assertion that checks that a diagram has a specific content.
 *
 * @property diagram The [Diagram] to check.
 * @property expectedContent The expected content.
 */
class DiagramHasContentAssertion(
    private val diagram: Diagram,
    private val expectedContent: String
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        assertThat(
            diagram.content()
        ).isEqualTo(expectedContent)
    }
}