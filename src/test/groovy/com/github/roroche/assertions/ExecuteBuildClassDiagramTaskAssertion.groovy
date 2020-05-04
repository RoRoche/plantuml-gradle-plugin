package com.github.roroche.assertions

import com.github.roroche.tasks.BuildClassDiagramTask
import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project

/**
 * Assertion that checks that BuildClassDiagramTask is properly executed.
 */
class ExecuteBuildClassDiagramTaskAssertion implements Assertion {

    private final Project project
    private final File output
    private final Assertion delegate

    /**
     * Primary constructor.
     *
     * @param project The Project to be configured.
     * @param output The output file of the task.
     * @param delegate The delegate assertion.
     */
    ExecuteBuildClassDiagramTaskAssertion(
            final Project project,
            final File output,
            final Assertion delegate) {
        this.project = project
        this.output = output
        this.delegate = delegate
    }

    /**
     * Check the assertion.
     * @throws Exception
     */
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
