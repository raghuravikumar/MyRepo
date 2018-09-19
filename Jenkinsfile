node{
    stage('scm checkout'){
        
        git 'https://github.com/raghuravikumar/MyRepo.git'
    }
    
    stage('compile-package'){
        
        sh 'mvn package'
    }
}
