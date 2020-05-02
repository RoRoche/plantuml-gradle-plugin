package com.github.roroche.assertions

import com.github.roroche.BuildClassDiagramTask
import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project
import org.gradle.api.Task

import static org.junit.jupiter.api.Assertions.assertNotNull

/**
 * Assertion that checks a task is properly created.
 */
class CreateTaskAssertion implements Assertion {

    private final Project project;
    private final String taskName;
    private final Class<? extends Task> taskClass;

    /**
     * Primary constructor.
     *
     * @param project The Project to be configured.
     * @param taskName The name of the task to create.
     * @param taskClass The Class of the task to create.
     */
    CreateTaskAssertion(
            final Project project,
            final String taskName,
            final Class<? extends Task> taskClass
    ) {
        this.project = project
        this.taskName = taskName
        this.taskClass = taskClass
    }

    /**
     * Check the assertion.
     * @throws Exception
     */
    @Override
    void check() throws Exception {
        final Task task = project.task(
                taskName,
                type: taskClass
        )
        assertNotNull(task)
        assertNotNull(taskClass.isInstance(task))
    }
}
