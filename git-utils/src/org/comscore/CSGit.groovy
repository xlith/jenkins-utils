class CSGit {
    static void main(String[] args) {
        
    }

    def call(args = null) {
       return this
    }

    static void printGitDiff() {
      sh 'git --no-pager diff'
      sh 'git status'
   }
}