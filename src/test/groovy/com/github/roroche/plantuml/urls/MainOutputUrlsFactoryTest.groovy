package com.github.roroche.plantuml.urls

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class MainOutputUrlsFactoryTest {

    Project project

    MainOutputUrlsFactoryTest() {
        project = ProjectBuilder.builder().build()
    }

    @Test
    void testCreateMainOutputUrlsShouldReturnCorrectClassPathForAndroidAppProject() {
        project.apply plugin: "com.android.application"
        project.apply plugin: "kotlin-android"
        project.android {
            compileSdkVersion 21
        }
        project.evaluate()

        Urls.Wrap urls = MainOutputUrlsFactory.createMainOutputUrls(project)

        File result = new File(urls.toList()[0].toURI())
        assert result == project.tasks.compileDebugKotlin.destinationDir
    }

    @Test
    void testCreateMainOutputUrlsShouldReturnCorrectClassPathForAndroidAppProjectWithBuildFlavors() {
        project.apply plugin: "com.android.application"
        project.apply plugin: "kotlin-android"
        project.android {
            compileSdkVersion 21

            flavorDimensions "client"
            productFlavors {
                free {
                    dimension "client"
                }
            }
        }
        project.evaluate()

        Urls.Wrap urls = MainOutputUrlsFactory.createMainOutputUrls(project)

        File result = new File(urls.toList()[0].toURI())
        assert result == project.tasks.compileFreeDebugKotlin.destinationDir
    }

    @Test
    void testCreateMainOutputUrlsShouldReturnCorrectClassPathForAndroidLibraryProject() {
        project.apply plugin: "com.android.library"
        project.apply plugin: "kotlin-android"
        project.android {
            compileSdkVersion 21
        }
        project.evaluate()

        Urls.Wrap urls = MainOutputUrlsFactory.createMainOutputUrls(project)

        File result = new File(urls.toList()[0].toURI())
        assert result == project.tasks.compileDebugKotlin.destinationDir
    }

    @Test
    void testCreateMainOutputUrlsShouldReturnCorrectClassPathForAndroidLibraryProjectWithBuildFlavors() {
        project.apply plugin: "com.android.library"
        project.apply plugin: "kotlin-android"
        project.android {
            compileSdkVersion 21

            flavorDimensions "client"
            productFlavors {
                free {
                    dimension "client"
                }
            }
        }
        project.evaluate()

        Urls.Wrap urls = MainOutputUrlsFactory.createMainOutputUrls(project)

        File result = new File(urls.toList()[0].toURI())
        assert result == project.tasks.compileFreeDebugKotlin.destinationDir
    }
}
