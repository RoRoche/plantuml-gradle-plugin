package com.github.roroche.assertions

import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project
import org.gradle.api.Task

import static org.junit.jupiter.api.Assertions.assertNotNull

/**
 * Assertion that checks a task is found in project.
 */
class FindTaskAssertion implements Assertion {

    private final Project project;
    private final String taskName;

    /**
     * Primary constructor.
     *
     * @param project The Project to be configured.
     * @param taskName The name of the task to find.
     */
    FindTaskAssertion(
            final Project project,
            final String taskName
    ) {
        this.project = project
        this.taskName = taskName
    }

    /**
     * Check the assertion.
     * @throws Exception
     */
    @Override
    void check() throws Exception {
        final Task task = project.tasks.findByName(taskName)
        assertNotNull(task)
    }
}
