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
                      body: "Please find results at the below link:
                                project url - "+ ${PROJECT_URL} + "
                                build url - "+ ${BUILD_URL} +"
                                job url - "+ ${JOB_URL} +"
                                build number - "+ ${BUILD_NUMBER} +"
                                job name = "+${JOB_NAME},
                      cc: '',
                      from: 'jyothikishore2023@gmail.com',
                      replyTo: '',
                      subject: "Result for build - "+ ${env.BUILD_NUMBER} +" # job - "+ ${env.JOB_NAME},
                      to: 'jyothikishore0208@gmail.com'
                      ])
//                emailext ([
//                           attachmentsPattern: 'test.zip',
//                           body: '''${SCRIPT, template="groovy-html.template"}''',
//                           subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Failed",
//                           mimeType: 'text/html',
//                           to: "email id"
//                           ])
                }
            }
        }
     }
    }
 }