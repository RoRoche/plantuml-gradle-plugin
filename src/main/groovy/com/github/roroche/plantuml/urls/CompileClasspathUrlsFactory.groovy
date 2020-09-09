package com.github.roroche.plantuml.urls

import org.gradle.api.Project

/**
 * Utility class to build Urls with compileClasspath configuration from Project.
 */
class CompileClasspathUrlsFactory {
    public static Urls.Wrap createCompileClasspathUrls(Project project) {
        if (isAndroidProject(project)) {
            def classpath = []

            project.android.getBootClasspath().each {
                classpath.add(it)
            }

            def debugVariant

            if (isAndroidLibrary(project)) {
                debugVariant = project.android.libraryVariants.find {
                    it.name.contains("debug") || it.name.contains("Debug")
                }
            } else {
                debugVariant = project.android.applicationVariants.find {
                    it.name.contains("debug") || it.name.contains("Debug")
                }
            }

            classpath.addAll(debugVariant.javaCompileProvider.get().classpath.files)

            return new CompileClasspathUrls(new FilesUrls(classpath.toSet()))
        } else {
            return new CompileClasspathUrls(project)
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
