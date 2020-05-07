package com.github.roroche.plantuml.urls

/**
 * Interface representing Urls inside the project.
 */
interface Urls {
    /**
     * @return The list of URL.
     */
    List<URL> toList()

    /**
     * Convenient class to wrap Urls.
     */
    abstract class Wrap implements Urls {
        protected final Urls origin

        /**
         * Primary constructor.
         *
         * @param origin The Urls to be decorated.
         */
        Wrap(final Urls origin) {
            this.origin = origin
        }

        /**
         * @return The list of URL.
         */
        @Override
        List<URL> toList() {
            return origin.toList()
        }
    }
}