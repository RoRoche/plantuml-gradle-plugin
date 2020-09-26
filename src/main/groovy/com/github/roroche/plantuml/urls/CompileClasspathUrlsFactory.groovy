package com.github.roroche.plantuml.urls

import org.gradle.api.Project

import static com.github.roroche.plantuml.android.AndroidProjectType.*

/**
 * Factory for creating the correct classpath based on the type of a project
 */
class CompileClasspathUrlsFactory {
    static Urls.Wrap createCompileClasspathUrls(Project project) {
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
}
