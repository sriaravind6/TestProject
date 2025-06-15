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