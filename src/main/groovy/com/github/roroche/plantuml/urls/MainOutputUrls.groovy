package com.github.roroche.plantuml.urls

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.SourceSetContainer

/**
 * Utility class to get project main output files.
 */
class MainOutputUrls extends Urls.Wrap {
    /**
     * Primary constructor.
     *
     * @param origin The Urls to be decorated.
     */
    MainOutputUrls(final Urls origin) {
        super(origin)
    }

    /**
     * Secondary constructor.
     *
     * @param project The Project where to find output main.
     */
    MainOutputUrls(final Project project) {
//        this(
//                project.getConvention().getPlugin(JavaPluginConvention.class).getSourceSets()
//        )
        this (
                new FilesUrls(
//                    project.fileTree(dir: project.tasks["compileDebugKotlin"].destinationDir, excludes: ["**/META-INF"]).files
                    [project.tasks["compileDebugKotlin"].destinationDir].toSet()
                )
        )
    }

    /**
     * Secondary constructor.
     *
     * @param ssc The SourceSetContainer where to find output main.
     */
    MainOutputUrls(final SourceSetContainer ssc) {
        this(
                new FilesUrls(
                        ssc.getByName("main").getOutput().getClassesDirs().getFiles()
                )
        )
    }
}
