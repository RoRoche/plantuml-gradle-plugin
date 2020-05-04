package com.github.roroche.plantuml.tasks

import com.github.roroche.plantuml.classes.*
import com.github.roroche.plantuml.diagrams.ClassDiagram
import com.github.roroche.plantuml.diagrams.Diagram
import com.github.roroche.plantuml.diagrams.DiagramWithLog
import org.gradle.api.DefaultTask
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

//    //region Getters
//    @Input
//    String getPackageName() {
//        return packageName
//    }
//
//    @Optional
//    @Input
//    List<String> getIgnoredClasses() {
//        return ignoredClasses
//    }
//
//    @OutputFile
//    File getOutputFile() {
//        return outputFile
//    }
//    //endregion
//
//    //region Setters
//    /**
//     * @param packageName The name of the package to scan.
//     */
//    @Option(
//            option = "packageName",
//            description = "The package where to scan classes to build the class diagram."
//    )
//    void setPackageName(final String packageName) {
//        this.packageName = packageName
//    }
//
//    /**
//     * @param ignoredClasses The classes to ignore while generating diagram.
//     */
//    @Option(
//            option = "ignoredClasses",
//            description = "[Optional] The classes to be ignored while building class diagram."
//    )
//    void setIgnoredClasses(final List<String> ignoredClasses) {
//        this.ignoredClasses = ignoredClasses
//    }
//
//    /**
//     * @param outputFile The file where to print diagram.
//     */
//    @Option(
//            option = "outputFile",
//            description = "The file where to print the built diagram."
//    )
//    void setOutputFile(final String outputFile) {
//        this.outputFile = new File(outputFile)
//    }
//    //endregion

    /**
     * Execute that action.
     */
    @TaskAction
    @Override
    void execute() {
        getLogger().debug(
                String.format("Package to scan: %s", extension.packageName)
        )
        getLogger().debug(
                String.format("Output file: %s", extension.outputFile)
        )
        getLogger().debug(
                String.format("Classes to ignore: %s", extension.ignoredClasses)
        )
        final Classes classes = new ClsWithLog(
                new ClsFiltered(
                        new ClsInPackage(extension.packageName),
                        new ClsWithNames(extension.ignoredClasses)
                ),
                getLogger()
        )
        final Diagram diagram = new DiagramWithLog(
                new ClassDiagram(classes),
                getLogger()
        )
        diagram.print(extension.outputFile)
    }
}
