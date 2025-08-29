@Library("jenkins-shared-lib") _
pipeline {
    agent any

    stages {
        stage ('Hello') {
            steps {
                helloWorld(name: "Slava", dayOfWeek: "Friday")
            }
        }
    }
}