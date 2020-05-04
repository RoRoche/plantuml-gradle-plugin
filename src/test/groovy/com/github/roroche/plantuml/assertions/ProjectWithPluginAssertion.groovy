package com.github.roroche.plantuml.assertions

import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project

import static org.junit.jupiter.api.Assertions.assertTrue

/**
 * Assertion that checks a plugin is properly applied to a project.
 */
class ProjectWithPluginAssertion implements Assertion {

    private final Project project
    private final String pluginId
    private final List<FindTaskAssertion> taskAssertions

    /**
     * Primary constructor.
     *
     * @param project The Project to be configured.
     * @param pluginId The ID of the plugin to apply.
     * @param taskAssertions The tasks to be found.
     */
    ProjectWithPluginAssertion(
            final Project project,
            final String pluginId,
            final List<FindTaskAssertion> taskAssertions
    ) {
        this.project = project
        this.pluginId = pluginId
        this.taskAssertions = taskAssertions
    }

    /**
     * Check the assertion.
     * @throws Exception
     */
    @Override
    void check() throws Exception {
        project.pluginManager.apply(pluginId)
        assertTrue(
                project.pluginManager.hasPlugin(pluginId)
        )
        taskAssertions.forEach { taskAssertion ->
            taskAssertion.check()
        }
    }
}
