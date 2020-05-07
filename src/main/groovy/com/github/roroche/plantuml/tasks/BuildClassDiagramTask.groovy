package com.github.roroche.plantuml.tasks

import com.github.roroche.plantuml.classes.*
import com.github.roroche.plantuml.diagrams.ClassDiagram
import com.github.roroche.plantuml.diagrams.Diagram
import com.github.roroche.plantuml.diagrams.DiagramWithLog
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject

/**
 * Task to build PlantUML class diagram.
 */
class BuildClassDiagramTask extends DefaultTask implements CustomTask {

    private ClassDiagramExtension extension

    @Inject
    BuildClassDiagramTask(final ClassDiagramExtension extension) {
        this.group = "documentation"
        this.description = "Build PlantUML class diagram for a given package."
        this.extension = extension
    }

    /**
     * Execute that action.
     */
    @TaskAction
    @Override
    void execute() {
        getLogger().debug(
                "Package to scan: {}",
                extension.packageName
        )
        getLogger().debug(
                "Output file: {}",
                extension.outputFile
        )
        getLogger().debug(
                "Classes to ignore: {}",
                extension.ignoredClasses
        )
        final ClassLoader classLoader = getClassLoader()
        final Classes classes = new ClsWithLog(
                new ClsFiltered(
                        new ClsInPackage(
                                extension.packageName,
                                classLoader
                        ),
                        new ClsWithNames(
                                extension.ignoredClasses,
                                classLoader
                        )
                ),
                getLogger()
        )
        final Diagram diagram = new DiagramWithLog(
                new ClassDiagram(classes),
                getLogger()
        )
        diagram.print(extension.outputFile)
    }

    @Internal
    protected ClassLoader getClassLoader() {
        final URL[] urls = project.sourceSets.main.output.classesDirs.files.collect {
            if (it != null) {
                it.toURI().toURL()
            }
        }.findAll {
            it != null
        } as URL[]
        getLogger().debug(
                "URLs to scan: " + urls
        )
        return new URLClassLoader(urls)
    }
}
