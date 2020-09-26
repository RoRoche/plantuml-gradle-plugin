package com.github.roroche.plantuml.urls

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class CompileClasspathUrlsFactoryTest {

    Project project

    CompileClasspathUrlsFactoryTest() {
        project = ProjectBuilder.builder().build()
    }

    @Test
    void testJavaProjectShouldReturnCorrectClassPathForAndroidAppProject() {
        project.apply plugin: "com.android.application"
        project.android {
            compileSdkVersion 21
        }
        project.evaluate()

        Urls.Wrap urls = CompileClasspathUrlsFactory.createCompileClasspathUrls(project)

        def files = []

        urls.toList().each { url ->
            files.add(new File(url.toURI()).getName())
        }

        assert files.contains("android.jar")
        assert files.contains("R.jar")
    }

    @Test
    void testJavaProjectShouldReturnCorrectClassPathForAndroidLibraryProject() {
        project.apply plugin: "com.android.library"
        project.android {
            compileSdkVersion 21
        }
        project.evaluate()

        Urls.Wrap urls = CompileClasspathUrlsFactory.createCompileClasspathUrls(project)

        def files = []

        urls.toList().each { url ->
            files.add(new File(url.toURI()).getName())
        }

        assert files.contains("android.jar")
        assert files.contains("R.jar")
    }
}
