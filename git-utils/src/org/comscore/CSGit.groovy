class CSGit {
    static CSGit main(args = null) {
        return this
    }

    def call(args = null) {
       return this
    }

    static void printGitDiff() {
      sh 'git --no-pager diff'
      sh 'git status'
   }
}