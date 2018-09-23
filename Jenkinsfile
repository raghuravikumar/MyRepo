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
        
        sh "mvn -f org-management/pom.xml clean package checkstyle:checkstyle findbugs:findbugs cobertura:cobertura pmd:pmd "
        
    }
    


    
}
