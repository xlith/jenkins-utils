class CSGit {
    static void main(String[] args) {
        
    }


    static void printGitDiff() {
      sh 'git --no-pager diff'
      sh 'git status'
   }
}