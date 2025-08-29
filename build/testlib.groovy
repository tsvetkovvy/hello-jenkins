@Library("jenkins-shared-lib") _
pipeline {
    agent any

    stages {
        stage ('Hello') {
            steps {
                script {
                    helloWorld()
                }
            }
        }
    }
}