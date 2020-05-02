package com.github.roroche.diagrams

import org.gradle.api.logging.Logger
import java.io.File

class DiagramWithLog(
    origin: Diagram,
    private val logger: Logger
): Diagram.Wrap(origin) {
    override fun content(): String {
        val content = super.content()
        logger.debug(
            "Content to print: $content"
        )
        return content
    }

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