#!/usr/bin/env groovy

def call(String tag_name, String ticket_id, String message) {
  sh "git tag -a ${tag_name} -m \"${ticket_id}: ${String}\""
  sh 'git push origin --tags'
}