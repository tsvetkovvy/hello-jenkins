def app_name = "hello-jenkins-server"
def cfg = ""


pipeline {
    agent any
    tools {
        maven "${cfg.MAVEN_VERSION}"
        jdk "${cfg.JDK_VERSION}"
    }
    stages {
        stage('Load config') {
            steps {
                script {
                    cfg = load "${app_name}/env.groovy"
                }
            }
        }
        stage('Checkout') {
            steps {
                git branch: "${cfg.GIT_BRANCH}", url: "${cfg.GIT_URL}"
            }
        }
        stage('Check Java and Maven versions') {
            steps {
                script {
                    sh 'java -version'
                    sh 'mvn --version'
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Run') {
            steps {
                echo "Build completed. Artifact: target/simple-jenkins-service-1.0.0.jar"
            }
        }
    }
}