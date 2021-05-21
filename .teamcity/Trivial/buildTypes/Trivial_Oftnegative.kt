package Trivial.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.schedule

object Trivial_Oftnegative : BuildType({
    name = "oftnegative"

    steps {
        script {
            scriptContent = "exit 1"
        }
    }

    triggers {
        schedule {
            schedulingPolicy = cron {
                seconds = "0/2"
                minutes = "*"
            }
            branchFilter = ""
            triggerBuild = always()
            withPendingChangesOnly = false
        }
    }
})
