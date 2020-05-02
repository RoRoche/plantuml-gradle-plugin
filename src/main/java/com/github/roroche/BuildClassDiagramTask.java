package com.github.roroche;

import com.github.roroche.classes.*;
import com.github.roroche.diagrams.ClassDiagram;
import com.github.roroche.diagrams.Diagram;
import com.github.roroche.diagrams.DiagramWithLog;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;

import java.io.File;
import java.util.List;

/**
 * Task to build PlantUML class diagram.
 */
public class BuildClassDiagramTask extends DefaultTask implements CustomTask {

    private String packageName;
    private List<String> ignoredClasses;
    private File outputFile;

    /**
     * @return The name of the package to scan.
     */
    @Input
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param packageName The name of the package to scan.
     */
    @Option(
            option = "packageName",
            description = "The package where to scan classes to build the class diagram."
    )
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * @return The classes to ignore while generating diagram.
     */
    @Optional
    @Input
    public List<String> getIgnoredClasses() {
        return ignoredClasses;
    }

    /**
     * @param ignoredClasses The classes to ignore while generating diagram.
     */
    @Option(
            option = "ignoredClasses",
            description = "The classes to be ignored while building class diagram."
    )
    public void setIgnoredClasses(List<String> ignoredClasses) {
        this.ignoredClasses = ignoredClasses;
    }

    /**
     * @return The file where to print diagram.
     */
    @OutputFile
    public File getOutputFile() {
        return outputFile;
    }

    /**
     * @param outputFile The file where to print diagram.
     */
    @Option(
            option = "ignoredClasses",
            description = "The classes to be ignored while building class diagram."
    )
    public void setOutputFile(final String outputFile) {
        this.outputFile = new File(outputFile);
    }

    /**
     * Populate params from extension to task.
     *
     * @param params The params to populate.
     */
    public void populateParam(final BuildClassDiagramExtension params) {
        this.packageName = params.getPackageName();
        this.outputFile = params.getOutputFile();
        this.ignoredClasses = params.getIgnoredClasses();
    }

    /**
     * Execute that action.
     */
    @TaskAction
    @Override
    public void execute() {
        setGroup("documentation");
        setDescription("Build PlantUML class diagram for a given package.");
        getLogger().debug(
                String.format("Package to scan: %s", packageName)
        );
        getLogger().debug(
                String.format("Output file: %s", outputFile)
        );
        getLogger().debug(
                String.format("Classes to ignore: %s", ignoredClasses)
        );
        final Classes classes = new ClsWithLog(
                new ClsFiltered(
                        new ClsInPackage(packageName),
                        new ClsWithNames(ignoredClasses)
                ),
                getLogger()
        );
        final Diagram diagram = new DiagramWithLog(
                new ClassDiagram(classes),
                getLogger()
        );
        diagram.print(outputFile);
    }
}
