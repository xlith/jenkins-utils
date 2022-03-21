class Git {
    static void printGitDiff() {
      sh 'git --no-pager diff'
      sh 'git status'
   }
}