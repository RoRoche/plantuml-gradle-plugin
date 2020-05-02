package com.github.roroche.assertions

import com.github.roroche.diagrams.Diagram
import com.github.roroche.diagrams.PrintedDiagram
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat
import java.io.File

class KtFileHasContentAssertion(
    private val file: File,
    private val expectedContent: String
) : Assertion {

    constructor(
        diagram: Diagram,
        file: File,
        expectedContent: String
    ) : this(
        PrintedDiagram(
            diagram,
            file
        ).file(),
        expectedContent
    )

    override fun check() {
        assertThat(
            file.readText()
        ).isEqualTo(
            expectedContent
        )
    }
}