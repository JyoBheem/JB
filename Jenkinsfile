pipeline {
    agent any

    stages {
            stage('Verify') {
                steps {
                    script {
                    bat 'gradle version'
                    }
                }
            }
            stage('Build') {
                steps {
                    script {
                    bat 'gradle build'
                    }
                }
            }
            stage('Test') {
                steps {
                  script {
                    bat 'gradlew clean test'
                  }
                }
            }
        }

        post {
                // If Gradle was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                      allowMissing: false,
                      alwaysLinkToLastBuild: false,
                      keepAll: false,
                      reportDir: 'lib/target/site/serenity/',
                      reportFiles: 'index.html',
                      reportName: 'Serenity Report',
                      reportTitles: '',
                      useWrapperFileDirectly: true])
                }
            }

    }