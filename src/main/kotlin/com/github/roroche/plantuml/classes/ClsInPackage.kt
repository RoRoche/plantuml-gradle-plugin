package com.github.roroche.plantuml.classes

import com.github.roroche.plantuml.classes.exceptions.InvalidPackageException
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import java.net.URL
import java.util.concurrent.Executors

/**
 * Utility class to find [Classes] in a given package.
 *
 * @property packageName The name of the package to scan.
 * @property packageUrls URL of the package (passed as [Collection]).
 * @property reflections Utility to find classes in pckage.
 */
class ClsInPackage(
    private val packageName: String,
    private val packageUrls: Collection<URL>,
    private val reflections: Reflections
) : Classes {

    /**
     * Secondary constructor using URLs.
     *
     * @param packageName The name of the package to scan.
     * @param packageUrls URL of the package (passed as [Collection]).
     */
    constructor(
        packageName: String,
        packageUrls: Collection<URL>
    ) : this(
        packageName,
        packageUrls,
        Reflections(
            ConfigurationBuilder()
                .setUrls(
                    packageUrls
                ).setScanners(
                    SubTypesScanner(false),
                    TypeAnnotationsScanner()
                ).setExecutorService(
                    Executors.newFixedThreadPool(4)
                )
        )
    )

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     */
    constructor(packageName: String) : this(
        packageName,
        ClasspathHelper.forPackage(packageName)
    )

    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        if (packageUrls.isNullOrEmpty()) {
            throw InvalidPackageException(packageName)
        }
        return reflections.getSubTypesOf(
            Any::class.java
        ).asIterable().toList()
    }
}