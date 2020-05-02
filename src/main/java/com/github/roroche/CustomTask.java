package com.github.roroche;

import org.gradle.api.tasks.TaskAction;

public interface CustomTask {
    /**
     * Execute that action.
     */
    @TaskAction
    void execute();
}
