#!/usr/bin/env groovy

def configureGit(String user, String email) {
  sh "git config user.name \"${user}\""
  sh "git config user.email \"${email}\""
}

def printGitDiff() {
  sh 'git --no-pager diff'
  sh 'git status'
}

def commitAll(String ticket_id, String message) {
  sh "git commit -am \"${ticket_id}: ${message}\""
}

def mergeOntoWithCommit(String from_branch, String onto_branch, String ticket_id, String message) {
  sh "git checkout ${onto_branch}"
  sh "git merge ${from_branch} --no-ff --no-edit -m \"${ticket_id}: ${message}\""

  sh "git push origin ${onto_branch}"
}

def createTag(String tag_name, String ticket_id, String message) {
  sh "git tag -a ${tag_name} -m \"${ticket_id}: ${String}\""
  sh 'git push origin --tags'
}


def mergeReleaseOntoMaster(String git_local_branch, String build_ticket_id, String new_version) {
  print_git_diff()
  commit_all(build_ticket_id, "Updates files with new build version ${new_version}")
  merge_onto_with_commit(git_local_branch, 'master', build_ticket_id, "New build ready version ${new_version}")
  create_tag(new_version, build_ticket_id, "New build ready version ${new_version}")
}

def resetDevelopToMaster() {
  sh 'git checkout -B develop'
  sh 'git push origin develop'
}