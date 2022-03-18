#!/usr/bin/env groovy

def call(String newVersion, String buildTicketID, String branchName) {
  sshagent(credentials : ['civan-test-dont-use']) {
      sh """
        git diff &&
        git status
        git commit -am "${buildTicketID}: New version ready to be published ${newVersion}" &&
        git tag -a "${newVersion}" -m "${buildTicketID}: New version ${newVersion}" &&
        git push --set-upstream origin ${branchName} &&
        git push --tags &&
        git push origin &&
        git diff
      """
  }
}

git diff &&
        git status
        git commit -am "TAG-1212: New version ready to be published 1.2.3" &&
        git tag -a "1.2.3" -m "TAG-1212: New version 1.2.3" &&
        git push --set-upstream origin main:main &&
        git push --tags &&
        git push origin &&
        git diff