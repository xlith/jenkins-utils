#!/usr/bin/env groovy

def call() {
  sh 'git checkout -B develop'
  sh 'git push origin develop'
}