package com.github.roroche;

import org.gradle.api.tasks.TaskAction;

public interface CustomTask {
    @TaskAction
    void execute();
}
