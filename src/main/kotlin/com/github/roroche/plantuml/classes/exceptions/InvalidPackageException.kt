package com.github.roroche.plantuml.classes.exceptions

/**
 * Exception to be thrown when a pckage is invalid.
 *
 * @param packageName The name of the package.
 */
class InvalidPackageException(
    packageName: String
) : RuntimeException("Invalid package '$packageName', maybe missing or empty")