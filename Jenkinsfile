node{
    
    // Wipe the workspace so we are building completely clean
    deleteDir()
    stage('scm checkout'){
        
        git 'https://github.com/raghuravikumar/MyRepo.git'
    }
    
    stage('compile-package'){
        
        sh 'mvn -f org-management/pom.xml package'
        
    }
    
    stage('analysis'){
        
        sh "mvn -f org-management/pom.xml clean package checkstyle:checkstyle findbugs:findbugs cobertura:cobertura "
        
    }
    
    stage('SonarQube analysis') {
    withSonarQubeEnv('My SonarQube Server Local') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'mvn -f org-management/pom.xml org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  } 

    
    step([$class: 'hudson.plugins.checkstyle.CheckStylePublisher', pattern: '**/target/checkstyle-result.xml', unstableTotalAll:'0',unhealthy:'100', healthy:'100'])
    step([$class: 'FindBugsPublisher', pattern: '**/findbugsXml.xml'])
    step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])

    
}
