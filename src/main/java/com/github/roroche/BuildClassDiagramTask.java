package com.github.roroche;

import com.github.roroche.classes.Classes;
import com.github.roroche.classes.ClsFiltered;
import com.github.roroche.classes.ClsInPackage;
import com.github.roroche.classes.ClsWithNames;
import com.github.roroche.diagrams.ClassDiagram;
import com.github.roroche.diagrams.Diagram;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;

import java.io.File;
import java.util.List;

public class BuildClassDiagramTask extends DefaultTask implements CustomTask {

    private String packageName;
    private List<String> ignoredClasses;
    private File outputFile;

    @Input
    public String getPackageName() {
        return packageName;
    }

    @Option(
            option = "packageName",
            description = "The package where to scan classes to build the class diagram."
    )
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Optional
    @Input
    public List<String> getIgnoredClasses() {
        return ignoredClasses;
    }

    @Option(
            option = "ignoredClasses",
            description = "The classes to be ignored while building class diagram."
    )
    public void setIgnoredClasses(List<String> ignoredClasses) {
        this.ignoredClasses = ignoredClasses;
    }

    @OutputFile
    public File getOutputFile() {
        return outputFile;
    }

    @Option(
            option = "ignoredClasses",
            description = "The classes to be ignored while building class diagram."
    )
    public void setOutputFile(final String outputFile) {
        this.outputFile = new File(outputFile);
    }

    public void populateParam(final BuildClassDiagramExtension params) {
        this.packageName = params.getPackageName();
        this.outputFile = params.getOutputFile();
        this.ignoredClasses = params.getIgnoredClasses();
    }

    @TaskAction
    @Override
    public void execute() {
        setGroup("documentation");
        setDescription("Build PlantUML class diagram for a given package.");
        final Classes classes = new ClsFiltered(
                new ClsInPackage(packageName),
                new ClsWithNames(ignoredClasses)
        );
        final Diagram diagram = new ClassDiagram(classes);
        diagram.print(outputFile);
    }
}
