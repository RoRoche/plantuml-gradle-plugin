package com.github.roroche.plantuml

import com.github.roroche.plantuml.tasks.BuildClassDiagramTask
import com.github.roroche.plantuml.tasks.ClassDiagramExtension

import javax.inject.Inject

/**
 * A mock BuildClassDiagramTask to replace the real one when testing.
 */
class MockBuildClassDiagramTask extends BuildClassDiagramTask {
    /**
     * Primary constructor.
     *
     * @param extension The injected ClassDiagramExtension.
     */
    @Inject
    MockBuildClassDiagramTask(final ClassDiagramExtension extension) {
        super(extension)
    }

    @Override
    protected ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader()
    }
}
