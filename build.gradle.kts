plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js(IR) {
        nodejs()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        jvmMain.dependsOn(commonMain)
        jsMain.dependsOn(commonMain)

        all {
            languageSettings {
                optIn("kotlin.Experimental")
                optIn("kotlinx.cli.ExperimentalCli")
            }
        }
    }
}