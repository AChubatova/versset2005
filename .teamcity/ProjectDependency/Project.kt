package ProjectDependency

import ProjectDependency.buildTypes.*
import ProjectDependency.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object Project : Project({
    id("ProjectDependency")
    name = "ProjectDependency"

    vcsRoot(ProjectDependency_Powershellchubatova)

    buildType(ProjectDependency_ConfigPowershell1)
    buildType(ProjectDependency_ConfigPowershell2)
    buildType(ProjectDependency_ConfigPowershell3)
})
