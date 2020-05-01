package com.github.roroche.classes

class ClsFiltered(
    origin: Classes,
    private val ignored: Classes
) : Classes.Wrap(origin) {
    override fun list(): List<Class<out Any>> {
        return when {
            origin.list().isEmpty() -> {
                emptyList()
            }
            ignored.list().isEmpty() -> {
                origin.list()
            }
            else -> {
                origin.list().filterNot { clazz ->
                    ignored.list().contains(clazz)
                }
            }
        }
    }
}