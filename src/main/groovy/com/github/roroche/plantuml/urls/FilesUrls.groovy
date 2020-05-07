package com.github.roroche.plantuml.urls

/**
 * Utility class that builds URL from File.
 */
class FilesUrls implements Urls {

    private final Set<File> files

    /**
     * Primary constructor.
     *
     * @param files The File to be transformed into URL.
     */
    FilesUrls(final Set<File> files) {
        this.files = files
    }

    /**
     * @return The list of URL.
     */
    @Override
    List<URL> toList() {
        return files.collect { final File file ->
            file.toURI().toURL()
        }
    }
}
