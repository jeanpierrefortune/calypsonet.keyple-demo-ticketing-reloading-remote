///////////////////////////////////////////////////////////////////////////////
//  GRADLE CONFIGURATION
///////////////////////////////////////////////////////////////////////////////
plugins {
    id("com.diffplug.spotless") version "6.25.0"
}
buildscript {
    val kotlinVersion: String by project
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("javax.xml.bind:jaxb-api:2.3.1")
        classpath("com.sun.xml.bind:jaxb-impl:2.3.9")
        classpath("org.eclipse.keypop:keypop-gradle:0.1.+") { isChanging = true }
    }
}

///////////////////////////////////////////////////////////////////////////////
//  APP CONFIGURATION
///////////////////////////////////////////////////////////////////////////////
allprojects {
    group = "org.calypsonet.keyple"
    repositories {
        mavenLocal()
        mavenCentral()
        maven(url = "https://nexus.coppernic.fr/repository/libs-release")
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        google()
    }
}

///////////////////////////////////////////////////////////////////////////////
//  TASKS CONFIGURATION
///////////////////////////////////////////////////////////////////////////////
tasks {
    spotless {
        kotlin {
            target("**/*.kt")
            ktfmt()
            licenseHeaderFile("${project.rootDir}/LICENSE_HEADER_BSD_3-CLAUSE")
        }
    }
}
