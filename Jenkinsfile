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
                      results: [[path: 'build/allure-results']]
                      ])
               mail ([
                      bcc: '',
                      body: '''Please find results at the below link:''',
                      cc: '',
                      from: 'jyothikishore2023@gmail.com',
                      replyTo: '',
                      subject: 'Smoke test result',
                      to: 'jyothikishore0208@gmail.com'
                      ])
                }
            }
        }
     }
    }
 }