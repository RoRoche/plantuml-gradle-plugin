package com.github.roroche.plantuml.classes

/**
 * Utility class to filter [Classes].
 *
 * @param origin The original [Classes] to filter.
 * @property ignored The [Classes] to be ignored.
 */
class ClsFiltered(
    origin: Classes,
    private val ignored: Classes
) : Classes.Wrap(origin) {
    /**
     * @return Filtered classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        return when {
            origin.list().isEmpty() -> {
                emptyList()
            }
            ignored.list().isEmpty() -> {
                origin.list()
            }
            else -> {
                origin.list().filterNot { clazz ->
                    ignored.list().contains(clazz)
                }
            }
        }
    }
}