package Trivial.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object Trivial_TrivialRegularLinux : BuildType({
    name = "trivial_regular_linux"

    vcs {
        root(Trivial.vcsRoots.Trivial_Composite)
    }

    steps {
        script {
            scriptContent = """
                for i in `seq 1 100`;
                do
                   sleep 3
                   echo "message ${'$'}i"
                
                done
            """.trimIndent()
        }
    }
})
