#!/usr/bin/env groovy

def call(String sourceBranch, String targetBranch) {
      sh """
        git fetch origin &&
        git checkout -b ${targetBranch} origin/${targetBranch} &&
        git merge ${sourceBranch} &&
        git push -v --tags --set-upstream origin HEAD:${targetBranch} &&
        git diff
      """
}