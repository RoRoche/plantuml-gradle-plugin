package com.github.roroche.plantuml.android

import com.github.roroche.plantuml.urls.MainOutputUrlsFactory
import com.github.roroche.plantuml.urls.Urls
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class AndroidProjectTypeTest {
    private final Project project = ProjectBuilder.builder().build()

    @Test
    void testProjectIsAndroidApplication() {
        project.apply plugin: "com.android.application"
        project.android {
            compileSdkVersion 21
        }
        project.evaluate()

        assert AndroidProjectType.isAndroidProject(project)
        assert AndroidProjectType.isAndroidApplication(project)
        assert !AndroidProjectType.isAndroidLibrary(project)
    }

    @Test
    void testProjectIsAndroidLibrary() {
        project.apply plugin: "com.android.library"
        project.android {
            compileSdkVersion 21
        }
        project.evaluate()

        assert AndroidProjectType.isAndroidProject(project)
        assert !AndroidProjectType.isAndroidApplication(project)
        assert AndroidProjectType.isAndroidLibrary(project)
    }

    @Test
    void testProjectIsNotAndroid() {
        assert !AndroidProjectType.isAndroidProject(project)
        assert !AndroidProjectType.isAndroidApplication(project)
        assert !AndroidProjectType.isAndroidLibrary(project)
    }
}
