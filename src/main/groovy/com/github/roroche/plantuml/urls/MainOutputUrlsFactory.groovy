package com.github.roroche.plantuml.urls

import org.gradle.api.Project
import org.gradle.api.tasks.SourceSetContainer

class MainOutputUrlsFactory {
    public static Urls.Wrap createMainOutputUrls(Project project) {
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

    private static boolean isAndroidProject(Project project) {
        return isAndroidApplication(project) || isAndroidLibrary(project)
    }

    private static boolean isAndroidApplication(Project project) {
        return project.pluginManager.hasPlugin("com.android.application")
    }

    private static boolean isAndroidLibrary(Project project) {
        return project.pluginManager.hasPlugin("com.android.library")
    }
}
