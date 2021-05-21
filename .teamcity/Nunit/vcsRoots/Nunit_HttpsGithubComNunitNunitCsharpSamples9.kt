package Nunit.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object Nunit_HttpsGithubComNunitNunitCsharpSamples9 : GitVcsRoot({
    name = "https://github.com/nunit/nunit-csharp-samples9"
    url = "https://github.com/nunit/nunit-csharp-samples"
    branch = "refs/heads/main"
    authMethod = password {
    }
    param("useAlternates", "true")
})
