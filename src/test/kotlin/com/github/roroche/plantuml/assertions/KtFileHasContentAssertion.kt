package com.github.roroche.plantuml.assertions

import com.github.roroche.plantuml.diagrams.Diagram
import com.github.roroche.plantuml.diagrams.PrintedDiagram
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat
import java.io.File

/**
 * Kotlin specific assertion that checks that a file has a specific content.
 *
 * @property file The [File] to check.
 * @property expectedContent The expected content.
 */
class KtFileHasContentAssertion(
    private val file: File,
    private val expectedContent: String
) : Assertion {

    /**
     * Secondary constructor to build defaults params.
     *
     * @param diagram The [Diagram] to print in [File].
     * @param file The [File] where to print the [Diagram].
     * @param expectedContent The expected content.
     */
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

    /**
     * Check the assertion.
     */
    override fun check() {
        val expectedContent = file.readText().replace("\r\n", "\n")

        assert(expectedContent.contains("interface \"Vehicle\"\n"))
        assert(expectedContent.contains("\"Car\" \"*\" <-> \"Driver\" : driver/cars\n"))
        assert(expectedContent.contains("\"Vehicle\" <|-- \"Car\""))
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