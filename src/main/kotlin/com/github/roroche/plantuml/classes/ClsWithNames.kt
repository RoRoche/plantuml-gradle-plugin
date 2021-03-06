package com.github.roroche.plantuml.classes

/**
 * Utility class to find [Classes] for names.
 *
 * @property names The names of the classes to find.
 * @property classLoader The [ClassLoader] to be used.
 */
class ClsWithNames(
    private val names: List<String>?,
    private val classLoader: ClassLoader
) : Classes {

    /**
     * Secondary constructor that builds default [ClassLoader].
     *
     * @param names The names of the classes to find.
     */
    constructor(
        names: List<String>?
    ) : this(
        names = names,
        classLoader = Thread.currentThread().contextClassLoader
    )

    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        return if (names?.isEmpty() != false) {
            emptyList()
        } else {
            names.map { name ->
                Class.forName(
                    name,
                    true,
                    classLoader
                )
            }
        }
    }
}