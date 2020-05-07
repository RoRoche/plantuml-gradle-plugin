package com.github.roroche.plantuml.classes

import org.gradle.api.logging.Logger

/**
 * Utility to add logging concerns.
 *
 * @param origin The delegate [Classes].
 * @property prefix The prefix to use in logs.
 * @property logger The [Logger] to use for debug concerns.
 */
class ClsWithLog(
    origin: Classes,
    private val prefix: String,
    private val logger: Logger
) : Classes.Wrap(origin) {
    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        val list = super.list()
        logger.debug(
            "$prefix classes: $list"
        )
        return list
    }
}