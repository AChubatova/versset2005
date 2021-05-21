package ProjectDependency.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.powerShell

object ProjectDependency_ConfigPowershell3 : BuildType({
    name = "ConfigPowershell3"

    vcs {
        root(ProjectDependency.vcsRoots.ProjectDependency_Powershellchubatova)
    }

    steps {
        powerShell {
            name = "step1"
            scriptMode = file {
                path = "output3_master.ps1"
            }
        }
    }

    dependencies {
        snapshot(ProjectDependency_ConfigPowershell2) {
        }
    }
})
