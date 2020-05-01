package com.github.roroche.classes

import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import java.util.concurrent.Executors

class ClsInPackage(
    private val reflections: Reflections
) : Classes {

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

    override fun list(): List<Class<out Any>> {
        return reflections.getSubTypesOf(
            Any::class.java
        ).asIterable().toList()
    }
}