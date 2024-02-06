plugins {
    java
    `maven-publish`
}

group = "org.clojars.mylesmegyesi"

java {
    // withJavadocJar()
    withSourcesJar()
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("lib") {
                afterEvaluate { from(components["java"]) }
            }
        }
        repositories {
            maven {
                name = "XXX"
                url = uri("${project.buildDir}/repo")
            }
        }
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
}