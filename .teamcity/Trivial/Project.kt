package Trivial

import Trivial.buildTypes.*
import Trivial.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object Project : Project({
    id("Trivial")
    name = "trivial"

    vcsRoot(Trivial_Composite)

    buildType(Trivial_TrivialLoong)
    buildType(Trivial_TrivialRegular)
    buildType(Trivial_Oft)
    buildType(Trivial_TrivialRegularLinux)
    buildType(Trivial_Oftnegative)

    features {
        feature {
            id = "PROJECT_EXT_2"
            type = "CloudImage"
            param("podTemplateMode", "simple")
            param("dockerImage", "jetbrains/teamcity-agent")
            param("profileId", "kube-1")
            param("imageDescription", "Run container: jetbrains/teamcity-agent")
            param("agent_pool_id", "-2")
            param("source-id", "jetbrains/teamcity-agent")
        }
        feature {
            id = "kube-1"
            type = "CloudProfile"
            param("secure:authToken", "")
            param("oidcClientId", "")
            param("secure:eksSecretKey", "")
            param("description", "")
            param("enabled", "true")
            param("profileInstanceLimit", "")
            param("idpIssuerUrl", "")
            param("apiServerUrl", "172.29.26.34:8080")
            param("eksAccessId", "")
            param("eksIAMRoleArn", "")
            param("secure:oidcClientSecret", "")
            param("profileServerUrl", "")
            param("authStrategy", "unauthorized")
            param("total-work-time", "")
            param("cloud-code", "kube")
            param("secure:oidcRefreshToken", "")
            param("secure:clientKeyData", "")
            param("eksClusterName", "")
            param("profileId", "kube-1")
            param("secure:clientCertData", "")
            param("secure:password", "")
            param("name", "kube")
            param("namespace", "")
            param("next-hour", "")
            param("secure:caCertData", "")
            param("terminate-idle-time", "30")
            param("username", "")
        }
    }
})
