def app_name = "hello-jenkins-server"
def cfg = ""
def maven_version = "maven-3.9.0"
def java_version = "java-21-openjdk-amd64"
//

pipeline {
    agent any
    tools {
        maven "${maven_version}"
        jdk "${java_version}"
    }
    stages {
        stage('Load config') {
            steps {
                script {
                    sh "ls -lha && tree"
                    cfg = load "build/${app_name}/env.groovy"
                }
            }
        }
        stage('Checkout') {
            steps {
                git credentialsId: "ssh-key-github",
                    branch: "${cfg.GIT_BRANCH}",
                    url: "${cfg.GIT_URL}"
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