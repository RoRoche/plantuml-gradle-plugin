package com.github.roroche.assertions

import com.pragmaticobjects.oo.tests.Assertion

import static org.assertj.core.api.Assertions.assertThat

class GrvFileHasContentAssertion implements Assertion {
    private final File file;
    private final String expectedContent;

    GrvFileHasContentAssertion(File file, String expectedContent) {
        this.file = file
        this.expectedContent = expectedContent
    }

    @Override
    void check() throws Exception {
        assertThat(
                file.text
        ).isEqualTo(
                expectedContent
        )
    }
}
