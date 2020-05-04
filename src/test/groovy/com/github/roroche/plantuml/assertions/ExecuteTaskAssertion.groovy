package com.github.roroche.plantuml.assertions

import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Task

/**
 * Assertion that checks that BuildClassDiagramTask is properly executed.
 */
class ExecuteTaskAssertion<T extends Task> implements Assertion {

    private final CreatedTask<T> createdTask
    private final Assertion delegate

    /**
     * Primary constructor.
     *
     * @param createdTask The task to create.
     * @param delegate The delegate assertion.
     */
    ExecuteTaskAssertion(
            final CreatedTask<T> createdTask,
            final Assertion delegate
    ) {
        this.createdTask = createdTask
        this.delegate = delegate
    }

    /**
     * Check the assertion.
     * @throws Exception
     */
    @Override
    void check() throws Exception {
        final Task task = createdTask.createdTask()
        task.execute()
        delegate.check()
    }
}
