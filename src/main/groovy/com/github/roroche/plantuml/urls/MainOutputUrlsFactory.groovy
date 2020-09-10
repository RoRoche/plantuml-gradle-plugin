package com.github.roroche.plantuml.urls

import org.gradle.api.Project

import static com.github.roroche.plantuml.android.AndroidProjectType.*

/***
 * Factory for creating the correct output URLs based on the type of a project
 */
class MainOutputUrlsFactory {
    static Urls.Wrap createMainOutputUrls(Project project) {
        if (isAndroidProject(project)) {
            def debugTask = project.tasks.find {
                it.name.contains("compile") && it.name.contains("DebugKotlin")
            }

            return new MainOutputUrls(
                new FilesUrls(
                    [debugTask.destinationDir].toSet()
                )
            )
        } else {
            return new MainOutputUrls(project)
        }
    }
}
