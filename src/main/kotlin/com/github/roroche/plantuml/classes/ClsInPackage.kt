package com.github.roroche.plantuml.classes

import com.github.roroche.plantuml.classes.exceptions.InvalidPackageException
import org.reflections.Configuration
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import org.reflections.util.ConfigurationBuilder
import java.net.URL
import java.net.URLClassLoader

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
     * @param classLoader The [ClassLoader] to use.
     */
    constructor(
        packageName: String,
        urls: Array<URL>,
        classLoader: ClassLoader
    ) : this(
        packageName = packageName,
        configuration = ConfigurationBuilder(
        ).setUrls(
            urls.toList()
        ).setScanners(
            SubTypesScanner(false),
            TypeAnnotationsScanner()
        ).addClassLoader(
            classLoader
        )
    )

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     * @param urls The [URL] array to use.
     */
    constructor(
        packageName: String,
        urls: Array<URL>
    ) : this(
        packageName = packageName,
        urls = urls,
        classLoader = URLClassLoader(urls)
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