package ProjectDependency.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object ProjectDependency_Powershellchubatova : GitVcsRoot({
    name = "powershellchubatova"
    url = "https://github.com/AChubatova/TC_Chubatova_Test_Repository"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:d8e0f0d0-4a49-415c-bf93-0892d8a44163"
    }
    param("useAlternates", "true")
})
