#!/usr/bin/env groovy

def call(String from_branch, String onto_branch, String ticket_id, String message) {
  sh "git checkout ${onto_branch}"
  sh "git merge ${from_branch} --no-ff --no-edit -m \"${ticket_id}: ${message}\""
  sh "git push origin ${onto_branch}"
}