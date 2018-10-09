node{
    
    // Wipe the workspace so we are building completely clean
    deleteDir()
    def mavenHome
        def utProjects = ["org-management-test"]
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
            stage('cucumber reporting') {
                for (project in utProjects) {
                    dir(project) {
                        sh "'${mavenHome}/bin/mvn' clean verify"
                    }
                }
            }
                
            }
             /*stage('SonarQube analysis') {
                    withSonarQubeEnv('My SonarQube Server') {
                    for (project in utProjects) {
                    dir(project) {
                        sh "'${mavenHome}/bin/mvn' sonar:sonar"
                        }
                     }
                }
            } */
            
        }

/*step([$class: 'CucumberReportPublisher',
           jenkinsBasePath: '',
           fileIncludePattern: '',
           fileExcludePattern: '',
           jsonReportDirectory: '',
           ignoreFailedTests: true,
           missingFails: false,
           pendingFails: false,
           skippedFails: false,
           undefinedFails: false,
           parallelTesting: false])
           
 */

/*
 * stage("Quality Gate"){ timeout(time: 5, unit: 'MINUTES') { def qg =
 * waitForQualityGate() if (qg.status != 'OK') { error
 * "Pipeline aborted due to quality gate failure: ${qg.status}" } } }
 */
