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
          remoteDirectory: "${remoteDir}",
          remoteDirectorySDF: false,
          removePrefix: '',
          sourceFiles: "${sourceDir}"
        ]],
      usePromotionTimestamp: false,
      useWorkspaceInPromotion: false,
      verbose: false
    ]])
}