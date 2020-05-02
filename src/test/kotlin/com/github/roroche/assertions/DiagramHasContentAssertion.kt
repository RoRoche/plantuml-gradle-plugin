package com.github.roroche.assertions

import com.github.roroche.diagrams.Diagram
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

class DiagramHasContentAssertion(
    private val diagram: Diagram,
    private val expectedContent: String
) : Assertion {
    override fun check() {
        assertThat(
            diagram.content()
        ).isEqualTo(expectedContent)
    }
}