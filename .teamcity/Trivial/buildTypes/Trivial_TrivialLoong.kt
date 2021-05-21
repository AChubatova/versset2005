package Trivial.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object Trivial_TrivialLoong : BuildType({
    name = "trivial_loong"

    vcs {
        root(Trivial.vcsRoots.Trivial_Composite)
    }

    steps {
        script {
            scriptContent = """
                echo "before sleep"
                ping -n 10 localhost > NUL
                echo "after sleep"
            """.trimIndent()
        }
    }
})
