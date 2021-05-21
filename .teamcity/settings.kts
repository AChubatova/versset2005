import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.schedule
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {
    description = "Contains all other projects"

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(Trivial)
    subProject(ProjectDependency)
}


object ProjectDependency : Project({
    name = "ProjectDependency"

    vcsRoot(ProjectDependency_Powershellchubatova)

    buildType(ProjectDependency_ConfigPowershell1)
    buildType(ProjectDependency_ConfigPowershell2)
    buildType(ProjectDependency_ConfigPowershell3)
})

object ProjectDependency_ConfigPowershell1 : BuildType({
    name = "ConfigPowershell1"

    vcs {
        root(ProjectDependency_Powershellchubatova)
    }

    steps {
        powerShell {
            name = "step1"
            scriptMode = file {
                path = "output3_master.ps1"
            }
        }
    }
})

object ProjectDependency_ConfigPowershell2 : BuildType({
    name = "ConfigPowershell2"

    vcs {
        root(ProjectDependency_Powershellchubatova)
    }

    steps {
        powerShell {
            name = "step1"
            scriptMode = file {
                path = "output4_master.ps1"
            }
        }
    }

    dependencies {
        snapshot(ProjectDependency_ConfigPowershell1) {
        }
    }
})

object ProjectDependency_ConfigPowershell3 : BuildType({
    name = "ConfigPowershell3"

    vcs {
        root(ProjectDependency_Powershellchubatova)
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

object ProjectDependency_Powershellchubatova : GitVcsRoot({
    name = "powershellchubatova"
    url = "https://github.com/AChubatova/TC_Chubatova_Test_Repository"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:d8e0f0d0-4a49-415c-bf93-0892d8a44163"
    }
    param("useAlternates", "true")
})


object Trivial : Project({
    name = "trivial"

    vcsRoot(Trivial_Composite)

    buildType(Trivial_TrivialLoong)
    buildType(Trivial_TrivialRegular)
    buildType(Trivial_Oft)
    buildType(Trivial_TrivialRegularLinux)
    buildType(Trivial_Oftnegative)

    features {
        feature {
            id = "PROJECT_EXT_2"
            type = "CloudImage"
            param("podTemplateMode", "simple")
            param("dockerImage", "jetbrains/teamcity-agent")
            param("profileId", "kube-1")
            param("imageDescription", "Run container: jetbrains/teamcity-agent")
            param("agent_pool_id", "-2")
            param("source-id", "jetbrains/teamcity-agent")
        }
        feature {
            id = "kube-1"
            type = "CloudProfile"
            param("secure:authToken", "")
            param("oidcClientId", "")
            param("secure:eksSecretKey", "")
            param("description", "")
            param("enabled", "true")
            param("profileInstanceLimit", "")
            param("idpIssuerUrl", "")
            param("apiServerUrl", "172.29.26.34:8080")
            param("eksAccessId", "")
            param("eksIAMRoleArn", "")
            param("secure:oidcClientSecret", "")
            param("profileServerUrl", "")
            param("authStrategy", "unauthorized")
            param("total-work-time", "")
            param("cloud-code", "kube")
            param("secure:oidcRefreshToken", "")
            param("secure:clientKeyData", "")
            param("eksClusterName", "")
            param("profileId", "kube-1")
            param("secure:clientCertData", "")
            param("secure:password", "")
            param("name", "kube")
            param("namespace", "")
            param("next-hour", "")
            param("secure:caCertData", "")
            param("terminate-idle-time", "30")
            param("username", "")
        }
    }
})

object Trivial_Oft : BuildType({
    name = "oft"

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

object Trivial_TrivialLoong : BuildType({
    name = "trivial_loong"

    vcs {
        root(Trivial_Composite)
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

object Trivial_TrivialRegular : BuildType({
    name = "trivial_regular"

    vcs {
        root(Trivial_Composite)
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

object Trivial_TrivialRegularLinux : BuildType({
    name = "trivial_regular_linux"

    vcs {
        root(Trivial_Composite)
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

object Trivial_Composite : GitVcsRoot({
    name = "composite"
    url = "https://github.com/AChubatova/composite"
    branch = "refs/heads/master"
    param("useAlternates", "true")
})
