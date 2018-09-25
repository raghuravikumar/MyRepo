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
        }
    
}
