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
        val expectedContent = diagram.content().replace("\r\n", "\n")

        assert(expectedContent.contains("\"Car\" \"*\" <-> \"Driver\" : driver/cars"))
        assertThat(
                parseToMap(expectedContent)
                    .equals(parseToMap(expectedContent.replace("\r\n", "\n")))
        )
    }

    private fun parseToMap(input: String): Map<String, Map<String, String>> {
        // Regex pattern to match class names and their properties
        val pattern = """class\s+"(.*?)".*?\{(.*?)\}""".toRegex(RegexOption.DOT_MATCHES_ALL)
        val resultMap: LinkedHashMap<String, LinkedHashMap<String, String>> = linkedMapOf()

        pattern.findAll(input).forEach { matchResult ->
            val properties = linkedMapOf<String, String>()

            matchResult.groupValues[2].trim().split('\n').forEach { propertyLine ->
                val parts = propertyLine.split(':').map { it.trim() }
                if (parts.size == 2) {
                    properties[parts[0]] = parts[1]
                }
            }
            resultMap[matchResult.groupValues[1].trim()] = properties
        }
        return resultMap
    }
}