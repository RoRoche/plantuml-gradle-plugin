package com.github.roroche.assertions

import com.github.roroche.BuildClassDiagramTask
import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project

class ExecuteBuildClassDiagramTaskAssertion implements Assertion {

    private final Project project
    private final File output
    private final Assertion delegate

    ExecuteBuildClassDiagramTaskAssertion(
            final Project project,
            final File output,
            final Assertion delegate) {
        this.project = project
        this.output = output
        this.delegate = delegate
    }

    @Override
    void check() throws Exception {
        final BuildClassDiagramTask task = project.task(
                "buildClassDiagramTask",
                type: BuildClassDiagramTask
        ) as BuildClassDiagramTask
        task.setPackageName("com.github.roroche.examples")
        task.setOutputFile(output.toString())
        task.execute()
        delegate.check()
    }
}
