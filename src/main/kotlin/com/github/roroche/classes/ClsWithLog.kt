package com.github.roroche.classes

import org.gradle.api.logging.Logger

/**
 * Utility to add logging concerns.
 *
 * @param origin The delegate [Classes].
 * @property logger The [Logger] to use for debug concerns.
 */
class ClsWithLog(
    origin: Classes,
    private val logger: Logger
) : Classes.Wrap(origin) {
    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        val list = super.list()
        logger.debug(
            "Classes to print in class diagram: $list"
        )
        return list
    }
}