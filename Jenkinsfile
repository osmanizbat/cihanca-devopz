pipeline {
    agent any

    environment {
        PROJECT_NAME = 'cihanca-devopz'
        APP_SERVER = '192.168.1.28'
    }    

    stages {

        stage('Build') {
            steps {
                echo 'Building..'
                sh '''
                    cd $PROJECT_NAME && pwd && ls -al
                    mvn clean package -DskipTests
                '''
            }
        }


        // stage('Test') {
        //     steps {
        //         echo 'Testing..'
        //         sh '''
        //             cd $PROJECT_NAME
        //             mvn test
        //             ls -al target/surefire-reports
        //         '''
        //         junit skipMarkingBuildUnstable: true, testResults: '**/surefire-reports/*.xml'                

        //     }
        // }


        // stage('Deploy') {
        //     steps {
        //         echo 'Deploying....'

        //         sh '''
        //             cd $PROJECT_NAME     
        //             scp -o StrictHostKeyChecking=no target/*.jar jenkins@$APP_SERVER:/opt/$PROJECT_NAME/$PROJECT_NAME.jar | exit 0
        //             ssh jenkins@$APP_SERVER "sudo /usr/bin/systemctl restart $PROJECT_NAME.service" 
        //         '''
        //     }
        // }
    }
}