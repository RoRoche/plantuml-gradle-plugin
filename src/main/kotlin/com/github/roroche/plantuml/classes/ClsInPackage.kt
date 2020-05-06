package com.github.roroche.plantuml.classes

import com.github.roroche.plantuml.classes.exceptions.InvalidPackageException
import org.reflections.Configuration
import org.reflections.Reflections

/**
 * Utility class to find [Classes] in a given package.
 *
 * @property packageName The name of the package to scan.
 * @property reflections Utility to find classes in pckage.
 */
class ClsInPackage(
    private val packageName: String,
    private val reflections: Reflections
) : Classes {

    /**
     * Secondary constructor with reflections configuration.
     *
     * @param packageName The name of the package to scan.
     * @param configuration The [Configuration] to use.
     */
    constructor(
        packageName: String,
        configuration: Configuration
    ) : this(
        packageName = packageName,
        reflections = Reflections(configuration)
    )

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     */
    constructor(
        packageName: String
    ) : this(
        packageName = packageName,
        reflections = Reflections(
            packageName,
            Thread.currentThread().contextClassLoader
        )
    )

    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        val list = reflections.getSubTypesOf(
            Any::class.java
        ).asIterable().toList()
        if (list.isNullOrEmpty()) {
            throw InvalidPackageException(packageName)
        }
        return list
    }
}