package Nunit.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object Nunit_HttpsGithubComAChubatovaNunitCppSamples : GitVcsRoot({
    name = "https://github.com/nunit/nunit-csharp-samples"
    url = "https://github.com/nunit/nunit-csharp-samples"
    branch = "refs/heads/master"
    param("useAlternates", "true")
})
