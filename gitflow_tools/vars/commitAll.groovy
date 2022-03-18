#!/usr/bin/env groovy

def call(String ticket_id, String message) {
  sh "git commit -am \"${ticket_id}: ${message}\""
}