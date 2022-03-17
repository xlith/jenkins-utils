#!/usr/bin/env groovy

def call(String sourceBranch, String targetBranch) {
  sshagent(credentials : ['civan-test-dont-use']) {
      sh """
        git fetch origin &&
        git checkout -b ${targetBranch} origin/${targetBranch} &&
        git merge ${sourceBranch} &&
        git push -v --tags --set-upstream origin ${targetBranch}:${targetBranch} &&
        git diff
      """
  }
}