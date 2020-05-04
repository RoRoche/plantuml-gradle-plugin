package com.github.roroche.plantuml.classes

/**
 * Classes to be used for diagram generation.
 */
interface Classes {
    /**
     * @return Classes to be used for diagram generation.
     */
    fun list(): List<Class<out Any>>

    /**
     * Convenient wrapper.
     *
     * @property origin The delegate.
     */
    abstract class Wrap(
        protected val origin: Classes
    ) : Classes by origin

    /**
     * Simple implementation containing a list of [Class].
     *
     * @property classes The list of [Class].
     */
    class Simple(
        private val classes: List<Class<out Any>>
    ) : Classes {
        /**
         * @return Classes to be used for diagram generation.
         */
        override fun list() = classes
    }
}