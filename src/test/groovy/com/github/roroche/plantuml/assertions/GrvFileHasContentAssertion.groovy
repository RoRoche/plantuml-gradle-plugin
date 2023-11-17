package com.github.roroche.plantuml.assertions

import com.pragmaticobjects.oo.tests.Assertion

import static org.assertj.core.api.Assertions.assertThat

/**
 * Groovy specific assertion to check that a file has a specific content.
 */
class GrvFileHasContentAssertion implements Assertion {
    private final File file
    private final String expectedContent

    /**
     * Primary constructor.
     *
     * @param file The file to check content.
     * @param expectedContent The expected content.
     */
    GrvFileHasContentAssertion(
            final File file,
            final String expectedContent
    ) {
        this.file = file
        this.expectedContent = expectedContent
    }

    /**
     * Check the assertion.
     * @throws Exception
     */
    @Override
    void check() throws Exception {
        def expectedContent = file.text.replace("\r\n", "\n")

        assert(expectedContent.contains("interface \"Vehicle\"\n"))
        assert(expectedContent.contains("\"Car\" \"*\" <-> \"Driver\" : driver/cars\n"))
        assert(expectedContent.contains("\"Vehicle\" <|-- \"Car\""))
        assertThat(
                parseToMap(expectedContent)
        ).isEqualTo(
                parseToMap(expectedContent.replace("\r\n", "\n"))
        )
    }

    private static Map<String, Map<String, String>> parseToMap(String input) {
        // Regex pattern to match class names and their properties
        def pattern = /class\s+"(.*?)".*?\{(.*?)\}/

        def resultMap = [:]

        (input =~ pattern).each { match ->
            def properties = [:]

            match[2].trim().split('\n').each { propertyLine ->
                def parts = propertyLine.split(':').collect { it.trim() }
                if (parts.size() == 2) {
                    properties[parts[0]] = parts[1]
                }
            }
            resultMap[match[1].trim()] = properties
        }
        return resultMap
    }
}
