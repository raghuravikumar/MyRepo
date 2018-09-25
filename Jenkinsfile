node{
    
    // Wipe the workspace so we are building completely clean
    deleteDir()
    def mavenHome
        def utProjects = ["org-management","user-management"]
        stage('Preparation') {
            checkout scm
            mavenHome = tool(name: 'maven', type: 'maven');
        }
        withEnv([
                'MAVEN_HOME=' + mavenHome,
                "PATH=${mavenHome}/bin:${env.PATH}"
        ]) {
            stage('compile-package') {
                for (project in utProjects) {
                    dir(project) {
                        sh "'${mavenHome}/bin/mvn' clean package"
                    }
                }
            }
             stage('SonarQube analysis') {
                    withSonarQubeEnv('My SonarQube Server') {
                    for (project in utProjects) {
                    dir(project) {
                        sh "'${mavenHome}/bin/mvn' sonar:sonar"
                        }
                     }
                }
            } 
            stage("Quality Gate"){
          timeout(time: 1, unit: 'MINUTES') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
            }
            
        }
    
}
