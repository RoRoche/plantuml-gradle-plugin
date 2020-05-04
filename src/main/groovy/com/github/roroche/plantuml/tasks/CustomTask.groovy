package com.github.roroche.plantuml.tasks

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