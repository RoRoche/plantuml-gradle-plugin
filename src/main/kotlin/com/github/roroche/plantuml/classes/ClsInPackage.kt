package com.github.roroche.plantuml.classes

import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import java.util.concurrent.Executors

/**
 * Utility class to find [Classes] in a given package.
 *
 * @property reflections Utility to find classes in pckage.
 */
class ClsInPackage(
    private val reflections: Reflections
) : Classes {

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     */
    constructor(packageName: String) : this(
        Reflections(
            ConfigurationBuilder()
                .setUrls(
                    ClasspathHelper.forPackage(packageName)
                ).setScanners(
                    SubTypesScanner(false),
                    TypeAnnotationsScanner()
                ).setExecutorService(
                    Executors.newFixedThreadPool(4)
                )
        )
    )

    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        return reflections.getSubTypesOf(
            Any::class.java
        ).asIterable().toList()
    }
}