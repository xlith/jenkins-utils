#!/usr/bin/env groovy

def call(String newVersion, String buildTicketID, String branchName) {
  sshagent(credentials : ['civan-test-dont-use']) {
      sh """
        git diff &&
        git status
        git commit -am "${buildTicketID}: New version ready to be published ${newVersion}" &&
        git tag -a "${newVersion}" -m "${buildTicketID}: New version ${newVersion}" &&
        git push --set-upstream origin HEAD:${branchName} &&
        git push --tags &&
        git push origin ${branchName} &&
        git diff
      """
  }
}