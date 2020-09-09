package com.github.roroche.plantuml.urls

import org.gradle.api.Project

import static com.github.roroche.plantuml.android.AndroidProjectType.*

/**
 * Utility class to build Urls with compileClasspath configuration from Project.
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
