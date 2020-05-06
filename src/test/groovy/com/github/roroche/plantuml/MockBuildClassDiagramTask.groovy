package com.github.roroche.plantuml

import com.github.roroche.plantuml.tasks.BuildClassDiagramTask
import com.github.roroche.plantuml.tasks.ClassDiagramExtension

import javax.inject.Inject

class MockBuildClassDiagramTask extends BuildClassDiagramTask {
    @Inject
    MockBuildClassDiagramTask(final ClassDiagramExtension extension) {
        super(extension)
    }

    @Override
    protected ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader()
    }
}
