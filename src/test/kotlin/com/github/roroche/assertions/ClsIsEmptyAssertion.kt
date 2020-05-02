package com.github.roroche.assertions

import com.github.roroche.classes.Classes
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

class ClsIsEmptyAssertion(
    private val classes: Classes
) : Assertion {
    override fun check() {
        assertThat(
            classes.list()
        ).isEmpty()
    }
}