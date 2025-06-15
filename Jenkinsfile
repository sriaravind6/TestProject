pipeline {
    agent any
    tools {
        maven 'Maven 3.9.6' // Update to your Maven installation name in Jenkins
        jdk 'jdk-21'         // Update to your JDK installation name in Jenkins
    }
    parameters {
        string(name: 'TAG', defaultValue: '@smoke', description: 'Cucumber tag to run')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                sh "mvn test -Dcucumber.filter.tags=${params.TAG}"
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}