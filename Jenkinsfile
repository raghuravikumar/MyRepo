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
        
        sh "mvn -f -X org-management/pom.xml clean package checkstyle:checkstyle findbugs:findbugs cobertura:cobertura "
        
    }
    
    step([$class: 'hudson.plugins.checkstyle.CheckStylePublisher', pattern: '**/target/checkstyle-result.xml', unstableTotalAll:'0',unhealthy:'100', healthy:'100'])
    step([$class: 'FindBugsPublisher', pattern: '**/findbugsXml.xml'])
    step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])

    
}
