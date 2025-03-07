pipeline{
    agent any
    tools{
        maven 'maven3'
    }
    environment{
        SONARQUBE_HOME = tool 'sonarqube-scanner' 
    }
    stages{
      stage('clean workspace'){
        steps{
          cleanWs()
        }
      }
        stage('clone'){
           steps{
             git 'https://github.com/vilas-13/chatroom.git'
           }
        }
        stage('compile'){
           steps{
             sh 'mvn clean compile'
           }
        }
        stage('test'){
           steps{
             sh 'mvn test'
           }
        }
        stage('trivy scannig'){
          steps{
            sh 'trivy fs --format table -o fs.html .'
          }
        }
         stage('sonarqube analasis'){
            steps{
                withSonarQubeEnv('sonarqube-server'){
                    sh ''' $SONARQUBE_HOME/bin/sonar-scanner -Dsonar.projectKey=chatroom \
                        -Dsonar.projectName=chatroom -Dsonar.java.binaries=target  '''
                }
            }
        }
        stage('package'){
            steps{
                sh 'mvn package'
            }
        }
         stage('deploy'){
            steps{
                withMaven(globalMavenSettingsConfig: 'maven-setting', jdk: '', maven: 'maven3', mavenSettingsConfig: '', traceability: true) {
                    sh 'mvn deploy'
                }
            }
        }
        stage('run the application'){
          steps{
            sh 'cd target && mv *.war /usr/local/tomcat/webapps/ROOT.war'
          }
        }
    }
}