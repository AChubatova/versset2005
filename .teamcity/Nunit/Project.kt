package Nunit

import Nunit.buildTypes.*
import Nunit.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object Project : Project({
    id("Nunit")
    name = "nunit"

    vcsRoot(Nunit_HttpsGithubComNunitNunitCsharpSamples9)
    vcsRoot(Nunit_HttpsGithubComAChubatovaNunitRefsHeadsMaster)
    vcsRoot(Nunit_HttpsGithubComNunitNunitCsharpSamples91)
    vcsRoot(Nunit_HttpsGithubComAChubatovaNunitCppSamples)

    buildType(Nunit_Build2)
    buildType(Nunit_Build3)
    buildType(Nunit_Build)
})
