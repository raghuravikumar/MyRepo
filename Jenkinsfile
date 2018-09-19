node{
    stage('scm checkout'){
        
        git 'https://github.com/raghuravikumar/MyRepo.git'
    }
    
    stage('compile-package'){
        
        sh 'mvn -f org-management/pom.xml package -DskipTests'
        
    }
    
    stage('SonarQube analysis') {
    withSonarQubeEnv('My SonarQube Server') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'mvn -f org-management/pom.xml org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
}
