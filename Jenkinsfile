pipeline {
    agent any
    parameters {
        string(name: 'TAG', defaultValue: '@smoke', description: 'Cucumber tag to run')
        string(name: 'FEATURE_PATH', defaultValue: 'src/test/resources/features/', description: 'Path to feature files')
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
                bat "mvn test -Dcucumber.filter.tags=%TAG% -Dcucumber.features=%FEATURE_PATH%"
            }
        }
    }
    post {
        always {
            junit 'target/cucumber-reports/*.xml'
        }
    }
}