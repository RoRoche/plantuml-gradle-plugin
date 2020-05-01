package com.github.roroche.classes

interface Classes {
    fun list(): List<Class<out Any>>

    abstract class Wrap(
        protected val origin: Classes
    ): Classes by origin
}