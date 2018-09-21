node{
    
    // Wipe the workspace so we are building completely clean
    deleteDir()
    stage('scm checkout'){
        
        git 'https://github.com/raghuravikumar/MyRepo.git'
    }
    
    stage('compile-package'){
        
        sh 'mvn -f org-management/pom.xml package'
        
    }
    
    stage('findbug'){
        sh 'mvn -f org-management/pom.xml  test package site'
    }
    
    stage('SonarQube analysis') {
    withSonarQubeEnv('My SonarQube Server') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'mvn -f org-management/pom.xml org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  } 
    stage("Quality Gate"){
        sh "sleep 10"
          timeout(time: 10, unit: 'MINUTES') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
        }  


    
}
