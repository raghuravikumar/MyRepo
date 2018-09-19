node{
    stage('scm checkout'){
        
        git 'https://github.com/raghuravikumar/MyRepo.git'
    }
    
    stage('compile-package'){
        
        sh 'mvn -f org-management/pom.xml package'
        
    }
    
    stage ('sonar analysis'){
        sh 'mvn -f org-management/pom.xml clean package sonar:sonar '
    }
}
