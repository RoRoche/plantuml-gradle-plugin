package com.github.roroche.plantuml.diagrams

import org.gradle.api.logging.Logger
import java.io.File

/**
 * Utility class to add logging concerns.
 *
 * @param origin The delegate [Diagram].
 * @property logger The [Logger] to use for debug concerns.
 */
class DiagramWithLog(
    origin: Diagram,
    private val logger: Logger
) : Diagram.Wrap(origin) {

    /**
     * Print the content into the [File].
     *
     * @param file The [File] where to print content.
     */
    override fun print(file: File) {
        logger.debug(
            "Start printing content to file: $file"
        )
        super.print(file)
        logger.debug(
            "Finish printing content to file: $file"
        )
    }
}