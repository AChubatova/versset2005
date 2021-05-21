package Trivial.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object Trivial_Composite : GitVcsRoot({
    name = "composite"
    url = "https://github.com/AChubatova/composite"
    branch = "refs/heads/master"
    param("useAlternates", "true")
})
