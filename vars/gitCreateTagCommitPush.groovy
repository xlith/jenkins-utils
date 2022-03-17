#!/usr/bin/env groovy

def call(String newVersion, String buildTicketID, String branchName) {
  sshagent(credentials : ['tagtesterGitSSH']) {
      sh """
        git diff &&
        git commit -am "${buildTicketID}: New version ready to be published ${newVersion}" &&
        git tag -a "${newVersion}" -m "${buildTicketID}: New version ${newVersion}" &&
        git push --set-upstream origin ${branchName}:${branchName} &&
        git push --tags &&
        git push origin &&
        git diff
      """
  }
}