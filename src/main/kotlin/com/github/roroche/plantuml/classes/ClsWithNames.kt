package com.github.roroche.plantuml.classes

/**
 * Utility class to find [Classes] for names.
 *
 * @property names The names of the classes to find.
 */
class ClsWithNames(
    private val names: List<String>?
): Classes {
    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        return if(names?.isEmpty() != false) {
            emptyList()
        } else {
            names.map { name ->
                Class.forName(name)
            }
        }
    }
}