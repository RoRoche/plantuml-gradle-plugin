package com.github.roroche.plantuml.tasks

/**
 * Extension for task {@link BuildClassDiagramTask}.
 */
class ClassDiagramExtension {

    List<Component> components = new ArrayList<>()

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
        components.add(new Component(packageName, outputFile, ignoredClasses))
    }

    /**
     * @return The name of the package to scan.
     */
    String getPackageName() {
        return packageName
    }

    private Component getOrCreateComponent() {
        if (components.isEmpty()) {
            components.add(new Component())
        }
        return components.get(components.size()-1);
    }

    /**
     * @param packageName The name of the package to scan.
     */
    void setPackageName(final String packageName) {
        getOrCreateComponent().packageName = packageName;
    }

    /**
     * @param outputFile The file where to print diagram.
     */
    void setOutputFile(final File outputFile) {
        getOrCreateComponent().outputFile = outputFile;
    }

    /**
     * @param ignoredClasses The classes to ignore while generating diagram.
     */
    void setIgnoredClasses(final List<String> ignoredClasses) {
        getOrCreateComponent().ignoredClasses = ignoredClasses;
    }

    void component(Closure callback) {
        components.add(new Component())
        callback()
    }

    static class Component {

        String packageName
        File outputFile
        List<String> ignoredClasses

        /**
         * Default constructor.
         */
        Component() {
        }

        /**
         * Primary constructor
         * @param packageName The name of the package to scan.
         * @param outputFile The file where to print diagram.
         * @param ignoredClasses The classes to ignore while generating diagram.
         */
        Component(
                final String packageName,
                final File outputFile,
                final List<String> ignoredClasses
        ) {
            this.packageName = packageName
            this.outputFile = outputFile
            this.ignoredClasses = ignoredClasses
        }
    }

}
