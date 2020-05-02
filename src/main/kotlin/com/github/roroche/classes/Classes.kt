package com.github.roroche.classes

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
    ): Classes by origin
}