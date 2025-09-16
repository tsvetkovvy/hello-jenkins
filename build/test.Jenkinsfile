pipeline {
    agent any

    environment {
        release_does_not_exist = ""
    }

    parameters {
        booleanParam(name: 'DRY_RUN', defaultValue: true, description: 'Only Dry Run')
    }

    stages {
        stage('Clean') {
            steps {
                cleanWs()
            }
        }

        stage('Check release') {
            steps {
                script {
                    release_does_not_exist = sh script: """
                        systemctl status blabla
                        """, returnStatus: true
                    if(release_does_not_exist) {
                        echo "Release does not exists"
                    }
                }
            }
        }

        stage('Backup') {
            when {
                expression {
                    return release_does_not_exist
                }
            }
            steps {
                echo "This is Backup stage! It works."
            }
        }

        stage('Dry Run') {
            when {
                expression {
                    return params.DRY_RUN
                }
            }
            steps {
                echo "This is Dry Run stage! It works."
            }
        }

        stage('Compare') {
            when {
                allOf {
                    expression { return params.DRY_RUN }
                    expression { return release_does_not_exist }
                }
            }
            steps {
                echo "This is Compare stage! It works."
            }
        }

        stage('Deploy') {
            when {
                expression {
                    return params.DRY_RUN == false
                }
            }
            steps {
                echo "This is Deploy stage! It works."
            }
        }
    }
}