#!/usr/bin/env groovy

def call(String sourceDir, String remoteDir) {
  cifsPublisher(publishers: [
    [
      configName: 'csnlfs01 - taggingproducts',
      transfers: [
        [
          cleanRemote: false,
          excludes: '',
          flatten: false,
          makeEmptyDirs: false,
          noDefaultExcludes: false,
          patternSeparator: '[, ]+',
          remoteDirectory: "${sourceDir}",
          remoteDirectorySDF: false,
          removePrefix: '',
          sourceFiles: "${remoteDir}"
        ]],
      usePromotionTimestamp: false,
      useWorkspaceInPromotion: false,
      verbose: false
    ]])
}