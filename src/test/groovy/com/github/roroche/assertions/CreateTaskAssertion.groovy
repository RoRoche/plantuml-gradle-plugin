package com.github.roroche.assertions

import com.github.roroche.BuildClassDiagramTask
import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project
import org.gradle.api.Task

import static org.junit.jupiter.api.Assertions.assertNotNull

class CreateTaskAssertion implements Assertion {

    private final Project project;
    private final String taskName;
    private final Class<? extends Task> taskClass;

    CreateTaskAssertion(
            final Project project,
            final String taskName,
            final Class<? extends Task> taskClass
    ) {
        this.project = project
        this.taskName = taskName
        this.taskClass = taskClass
    }

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
