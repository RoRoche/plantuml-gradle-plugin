package com.github.roroche.tasks

import org.gradle.api.tasks.TaskAction

/**
 * Interface to declare Gradle task.
 */
interface CustomTask {
    /**
     * Execute that action.
     */
    @TaskAction
    void execute();
}