#!/usr/bin/env groovy

def call() {
    sh 'git --no-pager diff'
    sh 'git status'
}