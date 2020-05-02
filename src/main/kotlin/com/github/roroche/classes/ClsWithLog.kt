package com.github.roroche.classes

import org.gradle.api.logging.Logger

class ClsWithLog(
    origin: Classes,
    private val logger: Logger
) : Classes.Wrap(origin) {
    override fun list(): List<Class<out Any>> {
        val list = super.list()
        logger.debug(
            "Classes to print in class diagram: $list"
        )
        return list
    }
}