package com.github.roroche.assertions

import com.pragmaticobjects.oo.tests.Assertion
import org.gradle.api.Project

import static org.junit.jupiter.api.Assertions.assertTrue

class ProjectWithPluginAssertion implements Assertion {

    private final Project project;
    private final String pluginId;
    private final List<FindTaskAssertion> taskAssertions;

    ProjectWithPluginAssertion(
            final Project project,
            final String pluginId,
            final List<FindTaskAssertion> taskAssertions
    ) {
        this.project = project
        this.pluginId = pluginId
        this.taskAssertions = taskAssertions
    }

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
