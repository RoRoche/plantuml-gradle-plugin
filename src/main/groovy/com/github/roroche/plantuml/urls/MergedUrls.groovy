package com.github.roroche.plantuml.urls

/**
 * Utility class to merge Urls.
 */
class MergedUrls implements Urls {
    private final List<Urls> urls

    /**
     * Primary constructor.
     *
     * @param urls The list of Urls to be merged.
     */
    MergedUrls(final List<Urls> urls) {
        this.urls = urls
    }

    /**
     * @return The list of merged URL.
     */
    @Override
    List<URL> toList() {
        return urls.collect {
            it.toList()
        }.flatten() as List<URL>
    }
}
