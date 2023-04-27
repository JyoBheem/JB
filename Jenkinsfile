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
                      body: "Please find the below details. /n Build - ${env.BUILD_URL} # job - ${env.JOB_URL} # Project - ${env.PROJECT_URL}",
                      cc: '',
                      from: 'jyothikishore2023@gmail.com',
                      replyTo: '',
                      subject: "Build - ${env.BUILD_NUMBER} # job - ${env.JOB_NAME}",
                      to: 'jyothikishore0208@gmail.com'
                      ])
//                emailext ([
//                           attachmentsPattern: 'allure-report.zip',
//                           body: '''Please find results at the below link:
//                                       project url -  ${env.PROJECT_URL}
//                                       build url -  ${env.BUILD_URL}
//                                       job url - ${env.JOB_URL}
//                                       build number - ${env.BUILD_NUMBER}
//                                       job name - ${env.JOB_NAME}''',
//                           subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER}",
//                           mimeType: 'text/html',
//                           to: 'jyothikishore0208@gmail.com',
//                           from:'jyothikishore2023@gmail.com'
//                           ])
                }
            }
        }
     }
    }
 }