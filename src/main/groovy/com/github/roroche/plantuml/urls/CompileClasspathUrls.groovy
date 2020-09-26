package com.github.roroche.plantuml.urls

import org.gradle.api.Project

/**
 * Utility class to build Urls with compileClasspath configuration from Project.
 */
class CompileClasspathUrls extends Urls.Wrap {
    /**
     * Primary constructor.
     *
     * @param origin The Urls to be decorated.
     */
    CompileClasspathUrls(final Urls origin) {
        super(origin)
    }

    /**
     * Secondary constructor.
     *
     * @param project The Project to scan.
     */
    CompileClasspathUrls(final Project project) {
        this(
                new FilesUrls(
                    project.configurations["compileClasspath"].files
                )
        )
    }
}
