package com.github.roroche;

import java.io.File;
import java.util.List;

/**
 * Extension for task {@link BuildClassDiagramTask}.
 */
public class BuildClassDiagramExtension {
    private String packageName;
    private File outputFile;
    private List<String> ignoredClasses;

    /**
     * @return The name of the package to scan.
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param packageName The name of the package to scan.
     */
    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }

    /**
     * @return The file where to print diagram.
     */
    public File getOutputFile() {
        return outputFile;
    }

    /**
     * @param outputFile The file where to print diagram.
     */
    public void setOutputFile(final File outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * @return The classes to ignore while generating diagram.
     */
    public List<String> getIgnoredClasses() {
        return ignoredClasses;
    }

    /**
     * @param ignoredClasses The classes to ignore while generating diagram.
     */
    public void setIgnoredClasses(final List<String> ignoredClasses) {
        this.ignoredClasses = ignoredClasses;
    }
}
