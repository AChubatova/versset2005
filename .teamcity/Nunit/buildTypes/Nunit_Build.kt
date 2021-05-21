package Nunit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.nuGetInstaller
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.nunit
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object Nunit_Build : BuildType({
    name = "Build"

    vcs {
        root(Nunit.vcsRoots.Nunit_HttpsGithubComAChubatovaNunitRefsHeadsMaster)
    }

    steps {
        dotnetBuild {
            enabled = false
            projects = "money/Money.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        nuGetInstaller {
            enabled = false
            toolPath = "%teamcity.tool.NuGet.CommandLine.DEFAULT%"
            projects = "TestProject/TestProjectMvcCore.sln"
        }
        dotnetBuild {
            projects = "C:/Nunit/TestProject/TestProjectTests/TestProjectTests.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        nunit {
            nunitPath = "%teamcity.tool.NUnit.Console.DEFAULT%"
            includeTests = """C:\Nunit\TestProject\TestProjectTests\bin\Debug\TestProjectTests.dll"""
        }
    }

    triggers {
        vcs {
        }
    }
})
