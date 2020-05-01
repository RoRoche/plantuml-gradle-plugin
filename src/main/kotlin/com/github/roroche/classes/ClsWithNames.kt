package com.github.roroche.classes

class ClsWithNames(
    private val names: List<String>?
): Classes {
    override fun list(): List<Class<out Any>> {
        return if(names?.isEmpty() != false) {
            emptyList()
        } else {
            names.map { name ->
                Class.forName(name)
            }
        }
    }
}