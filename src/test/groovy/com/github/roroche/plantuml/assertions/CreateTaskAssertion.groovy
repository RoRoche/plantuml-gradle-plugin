package com.github.roroche.plantuml.assertions

import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Task

import static org.junit.jupiter.api.Assertions.assertNotNull

/**
 * Assertion that checks a task is properly created.
 */
class CreateTaskAssertion<T extends Task> implements Assertion {

    private final CreatedTask createdTask
    private final Class<T> taskClass

    /**
     * @param createdTask The created task.
     * @param taskClass The Class of the task to create.
     */
    CreateTaskAssertion(
            final CreatedTask createdTask,
            final Class<T> taskClass
    ) {
        this.createdTask = createdTask
        this.taskClass = taskClass
    }

    /**
     * Check the assertion.
     * @throws Exception
     */
    @Override
    void check() throws Exception {
        final Task task = createdTask.createdTask()
        assertNotNull(task)
        assertNotNull(taskClass.isInstance(task))
    }
}
