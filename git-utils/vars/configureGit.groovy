#!/usr/bin/env groovy

def call(String user, String email) {
  sh "git config user.name \"${user}\""
  sh "git config user.email \"${email}\""
}