package Nunit.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object Nunit_HttpsGithubComAChubatovaNunitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/AChubatova/nunit#refs/heads/master"
    url = "https://github.com/AChubatova/nunit"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:c1649629-4076-4ca7-a1fe-701d4a9397c3"
    }
    param("useAlternates", "true")
})
