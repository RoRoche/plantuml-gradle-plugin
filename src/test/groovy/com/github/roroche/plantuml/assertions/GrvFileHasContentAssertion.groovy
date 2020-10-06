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
        assertThat(
                file.text.replace("\r\n", "\n")
        ).isEqualTo(
                expectedContent.replace("\r\n", "\n")
        )
    }
}
