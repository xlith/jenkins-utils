#!/usr/bin/env groovy

def call(String user, String email) {
    sh 'git --no-pager diff'
    sh 'git status'
}