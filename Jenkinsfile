pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }

        stage('Test') {
            //Saltamos todo el stage de 'Test'
            when { expression { false } }

            parallel {
                stage('test: chrome') {
                    steps {
                        sh './gradlew test'
                    }
                }

                stage('test: firefox') {
                    steps {
                        sh './gradlew testFirefox'
                    }
                }
            }

            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }
        stage('Security') {
            steps {
                sh '/usr/local/bin/trivy fs --format json --output trivy-results.json .'
            }

            post {
                always {
                    recordIssues(tools: [trivy(pattern: 'trivy-results.json')])
                }
            }
        }
    }
}