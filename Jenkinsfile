node{
    stage('scm checkout'){
        
        git 'https://github.com/raghuravikumar/MyRepo.git/org-management'
    }
    
    stage('compile-package'){
        
        sh 'mvn package'
    }
}
