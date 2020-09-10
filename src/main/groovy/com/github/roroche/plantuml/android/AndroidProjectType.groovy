package com.github.roroche.plantuml.android

import org.gradle.api.Project

/***
 * Class to determine if a project has an Android plugin applied
 */
class AndroidProjectType {
    private AndroidProjectType() {

    }

    static boolean isAndroidProject(Project project) {
        return isAndroidApplication(project) || isAndroidLibrary(project)
    }

    static boolean isAndroidApplication(Project project) {
        return project.pluginManager.hasPlugin("com.android.application")
    }

    static boolean isAndroidLibrary(Project project) {
        return project.pluginManager.hasPlugin("com.android.library")
    }
}
