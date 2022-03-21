class Git {
    static void main() {
   }

    static void printGitDiff() {
      sh 'git --no-pager diff'
      sh 'git status'
   }
}