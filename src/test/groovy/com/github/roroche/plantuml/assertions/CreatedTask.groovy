package com.github.roroche.plantuml.assertions

import org.gradle.api.Project
import org.gradle.api.Task

/**
 * Convenient class to created a Gradle task.
 */
class CreatedTask<T extends Task> {
    private final Project project
    private final String taskName
    private final Class<T> taskClass
    private final Object extension

    /**
     * Primary constructor.
     *
     * @param project The Project to be configured.
     * @param taskName The name of the task to create.
     * @param taskClass The Class of the task to create.
     * @paral extension The extension for the task.
     */
    CreatedTask(
            final Project project,
            final String taskName,
            final Class<? extends Task> taskClass,
            final Object extension
    ) {
        this.project = project
        this.taskName = taskName
        this.taskClass = taskClass
        this.extension = extension
    }

    Task createdTask() {
        return project.tasks.create(
                taskName,
                taskClass,
                extension
        )
    }
}
