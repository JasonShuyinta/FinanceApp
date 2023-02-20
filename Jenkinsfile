pipeline {
        agent any

        tools {
            maven 'maven_3.8.6'
            jdk 'jdk17'
        }

        stages {
            stage('Git Checkout') {
                steps {
                    checkout([$class: 'GitSCM', branches: [[name: '**']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubPasswordLocalSystem', url: 'https://github.com/JasonShuyinta/FinanceApp.git']]])
                }
            }
            stage('Build Artifacts') {
                steps {
                    bat 'mvn clean install'
                }
                post {
                    success {
                        bat '''
                        cd target
                        rename \"budget-finance.jar\" \"budget-finance-%BUILD_NUMBER%.jar\"
                        '''
                        archiveArtifacts 'target/*.jar'
                    }
                }
            }
            stage('Create and push docker image to ECR') {
                steps {
                    bat 'aws ecr-public get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws/e3x2p2e8'
                    bat 'docker build -t budgetfinance .'
                    bat 'docker tag budgetfinance:latest public.ecr.aws/e3x2p2e8/budgetfinance:latest'
                    bat 'docker push public.ecr.aws/e3x2p2e8/budgetfinance:latest'
                }
            }
     }
}