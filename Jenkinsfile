pipeline {
    agent any

    stages {
            stage('Test') {
                steps {
                  script {
                    bat "gradlew clean test"
                  }
                }

         post('Publish Report') {
           always {
             script {
              testNG()
               allure([
                     includeProperties: false,
                      jdk: '',
                      reportBuildPolicy: 'ALWAYS',
                      results: [[path: 'allure-results']]
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
 }