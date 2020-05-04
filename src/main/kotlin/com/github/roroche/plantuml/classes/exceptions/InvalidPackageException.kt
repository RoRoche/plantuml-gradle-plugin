package com.github.roroche.plantuml.classes.exceptions

class InvalidPackageException(
    packageName: String
) : RuntimeException("Invalid package '$packageName', maybe missing or empty")