pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'vickneee'
        DOCKERHUB_REPO = 'vickneee/jenkins-docker-demo'
        DOCKER_IMAGE_TAG = 'latest'
    }

    tools {
        jdk 'JAVA_HOME'   // Match Jenkins global config Manage Jenkins Tools JDK installations
        maven 'MAVEN_HOME'    // Match Jenkins global config Manage Jenkins Tools Maven installations
    }

    stage('Check Tools') {
        steps {
            sh 'echo $JAVA_HOME'
            sh 'echo $MAVEN_HOME'
            sh 'java -version'
            sh 'mvn -version'
        }
    }

    stage('Print Maven Home') {
        steps {
            sh 'echo $MAVEN_HOME'
            sh 'mvn -version'
        }
    }

    stages {
        stage('Print Environment') {
            steps {
                bat 'echo %PATH%'
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/vickneee/jenkins-docker-demo.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def app = docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKERHUB_CREDENTIALS_ID}") {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}