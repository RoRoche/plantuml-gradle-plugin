package com.github.roroche.assertions

import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project
import org.gradle.api.Task

import static org.junit.jupiter.api.Assertions.assertNotNull

class FindTaskAssertion implements Assertion {

    private final Project project;
    private final String taskName;

    FindTaskAssertion(
            final Project project,
            final String taskName
    ) {
        this.project = project
        this.taskName = taskName
    }

    @Override
    void check() throws Exception {
        final Task task = project.tasks.findByName(taskName)
        assertNotNull(task)
    }
}
