package Nunit.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object Nunit_HttpsGithubComNunitNunitCsharpSamples91 : GitVcsRoot({
    name = "https://github.com/nunit/nunit-csharp-samples9 (1)"
    url = "https://github.com/nunit/nunit-csharp-samples"
    branch = "refs/heads/master"
    param("useAlternates", "true")
})
