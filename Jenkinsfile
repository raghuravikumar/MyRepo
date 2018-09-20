node{
    
    // Wipe the workspace so we are building completely clean
    deleteDir()
    stage('scm checkout'){
        
        git 'https://github.com/raghuravikumar/MyRepo.git'
    }
    
    stage('compile-package'){
        
        sh 'mvn -f org-management/pom.xml package'
        
    }
    
    stage('SonarQube analysis') {
    withSonarQubeEnv('My SonarQube Server Local') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'mvn -f org-management/pom.xml org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
    
    stage("Quality Gate"){
          timeout(time: 2, unit: 'MINUTES') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
        }  
    
}
