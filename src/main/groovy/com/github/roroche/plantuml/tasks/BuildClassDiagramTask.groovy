package com.github.roroche.plantuml.tasks

import com.github.roroche.plantuml.classes.*
import com.github.roroche.plantuml.diagrams.ClassDiagram
import com.github.roroche.plantuml.diagrams.Diagram
import com.github.roroche.plantuml.diagrams.DiagramWithLog
import com.github.roroche.plantuml.urls.CompileClasspathUrls
import com.github.roroche.plantuml.urls.LoggableUrls
import com.github.roroche.plantuml.urls.MainOutputUrls
import com.github.roroche.plantuml.urls.MergedUrls
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject

/**
 * Task to build PlantUML class diagram.
 */
class BuildClassDiagramTask extends DefaultTask implements CustomTask {

    private ClassDiagramExtension extension

    /**
     * Injectable constructor.
     *
     * @param extension The ClassDiagramExtension to be injected.
     */
    @Inject
    BuildClassDiagramTask(final ClassDiagramExtension extension) {
        this.group = "plantuml"
        this.description = "Build PlantUML class diagram for a given package."
        this.extension = extension
    }

    /**
     * Execute that action.
     */
    @TaskAction
    @Override
    void execute() {
        for (def component : extension.components) {
            executeConfig(component)
        }
    }

    @Internal
    protected void executeConfig(ClassDiagramExtension.Component component) {
        logger.debug(
                "Package to scan: {}",
                component.packageName
        )
        logger.debug(
                "Output file: {}",
                component.outputFile
        )
        logger.debug(
                "Classes to ignore: {}",
                component.ignoredClasses
        )
        final ClassLoader classLoader = getClassLoader()
        final Classes classes = new ClsWithLog(
                new ClsFiltered(
                        new ClsWithLog(
                                new ClsInPackage(
                                        component.packageName,
                                        classLoader
                                ),
                                "Package content ->",
                                logger
                        ),
                        new ClsWithLog(
                                new ClsWithNames(
                                        component.ignoredClasses,
                                        classLoader
                                ),
                                "To ignore ->",
                                logger
                        )
                ),
                "To print in class diagram ->",
                logger
        )
        final Diagram diagram = new DiagramWithLog(
                new ClassDiagram(classes),
                logger
        )
        diagram.print(component.outputFile)
    }

    @Internal
    protected ClassLoader getClassLoader() {
        return new URLClassLoader(
                new MergedUrls(
                        Arrays.asList(
                                new LoggableUrls(
                                        new CompileClasspathUrls(project),
                                        "CompileClasspath",
                                        logger
                                ),
                                new LoggableUrls(
                                        new MainOutputUrls(project),
                                        "MainOutput",
                                        logger
                                )
                        )
                ).toList() as URL[]
        )
    }
}
