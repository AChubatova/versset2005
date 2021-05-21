package Trivial.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object Trivial_TrivialRegular : BuildType({
    name = "trivial_regular"

    vcs {
        root(Trivial.vcsRoots.Trivial_Composite)
    }

    steps {
        script {
            scriptContent = """
                for /l %%%%X in (1, 1, 100) do (
                  echo message %%%%X
                  ping -n 3 localhost > NUL
                )
            """.trimIndent()
        }
    }
})
