pipeline {
    agent any

    stages {
            stage('Test') {
                steps {
                  script {
                    bat "gradlew clean test"
                  }
                }

                post {
                // If Gradle was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                   success {
                    testNG()
                    allure([
                     includeProperties: false,
                      jdk: '',
                      reportBuildPolicy: 'ALWAYS',
                      results: [[path: 'target/allure-results']]
                      ])
                      mail ([
                      bcc: '',
                      body: '''Please find results at the below link:''',
                      cc: '',
                      from: '',
                      replyTo: '',
                      subject: 'Smoke test result',
                      to: 'jyothi.jo6@gmail.com'
                      ])
                }
            }
        }
    }
 }