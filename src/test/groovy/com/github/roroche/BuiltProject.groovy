package com.github.roroche

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

@Singleton
class BuiltProject {
    private final Project project = ProjectBuilder.builder().build()

    public Project toProject() {
        return project
    }
}
