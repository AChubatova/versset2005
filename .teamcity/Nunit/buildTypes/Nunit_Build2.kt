package Nunit.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*

object Nunit_Build2 : BuildType({
    name = "build2"

    vcs {
        root(Nunit.vcsRoots.Nunit_HttpsGithubComNunitNunitCsharpSamples9)
    }
})
