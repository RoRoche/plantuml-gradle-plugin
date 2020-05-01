package com.github.roroche;

import java.io.File;
import java.util.List;

public class BuildClassDiagramExtension {
    private String packageName;
    private File outputFile;
    private List<String> ignoredClasses;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(final File outputFile) {
        this.outputFile = outputFile;
    }

    public List<String> getIgnoredClasses() {
        return ignoredClasses;
    }

    public void setIgnoredClasses(final List<String> ignoredClasses) {
        this.ignoredClasses = ignoredClasses;
    }
}
