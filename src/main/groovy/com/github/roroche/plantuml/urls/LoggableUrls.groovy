package com.github.roroche.plantuml.urls

import org.gradle.api.logging.Logger

/**
 * Utility class to log Urls.
 */
class LoggableUrls extends Urls.Wrap {

    private final String prefix
    private final Logger logger

    /**
     * Primary constructor.
     *
     * @param origin The Urls to be logged.
     * @param prefix The prefix to use in logs.
     * @param logger The Logger to print logs.
     */
    LoggableUrls(
            final Urls origin,
            final String prefix,
            final Logger logger
    ) {
        super(origin)
        this.prefix = prefix
        this.logger = logger
    }

    /**
     * Logs list of URL before returning it.
     *
     * @return The list of URL.
     */
    @Override
    List<URL> toList() {
        def list = super.toList()
        logger.debug(
                "{} urls: {}",
                prefix,
                list
        )
        return list
    }
}
