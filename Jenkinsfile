pipeline {
    agent any
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
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                bat "mvn test -Dcucumber.filter.tags=%TAG%"
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}