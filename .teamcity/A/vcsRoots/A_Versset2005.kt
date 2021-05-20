package A.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object A_Versset2005 : GitVcsRoot({
    uuid = "325f4953-8a2c-4f93-9277-c854f554eadc"
    name = "versset2005"
    url = "https://github.com/AChubatova/versset2005"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:6c3b0283-7a1c-409a-97c3-ea365ff521e3"
    }
})
