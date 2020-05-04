package com.github.roroche.plantuml.tasks

/**
 * Extension for task {@link BuildClassDiagramTask}.
 */
class ClassDiagramExtension {
    private String packageName
    private File outputFile
    private List<String> ignoredClasses

    /**
     * Default constructor.
     */
    ClassDiagramExtension() {
    }

    /**
     * Primary constructor
     * @param packageName The name of the package to scan.
     * @param outputFile The file where to print diagram.
     * @param ignoredClasses The classes to ignore while generating diagram.
     */
    ClassDiagramExtension(
            final String packageName,
            final File outputFile,
            final List<String> ignoredClasses
    ) {
        this.packageName = packageName
        this.outputFile = outputFile
        this.ignoredClasses = ignoredClasses
    }

    /**
     * @return The name of the package to scan.
     */
    String getPackageName() {
        return packageName
    }

    /**
     * @param packageName The name of the package to scan.
     */
    void setPackageName(final String packageName) {
        this.packageName = packageName
    }

    /**
     * @return The file where to print diagram.
     */
    File getOutputFile() {
        return outputFile
    }

    /**
     * @param outputFile The file where to print diagram.
     */
    void setOutputFile(final File outputFile) {
        this.outputFile = outputFile
    }

    /**
     * @return The classes to ignore while generating diagram.
     */
    List<String> getIgnoredClasses() {
        return ignoredClasses
    }

    /**
     * @param ignoredClasses The classes to ignore while generating diagram.
     */
    void setIgnoredClasses(final List<String> ignoredClasses) {
        this.ignoredClasses = ignoredClasses
    }
}
