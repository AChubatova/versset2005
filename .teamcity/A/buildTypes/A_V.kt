package A.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*

object A_V : BuildType({
    name = "v"

    vcs {
        root(A.vcsRoots.A_Versset2005)
    }
})
