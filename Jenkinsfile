pipeline {
    agent any

    environment {
        PROJECT_NAME = 'cihanca-devopz'
        APP_SERVER = 'app-server'
        DOCKER_REGISTRY = 'localhost:5000'
    }    

    stages {

        stage('Build jar packages') {
            steps {
                echo 'Building jar packages'
                sh '''
                    pwd && ls -al
                    mvn clean package -DskipTests
                '''
            }
        }

        stage('Build docker images') {
            steps {
                echo 'Building Docker images'
                sh '''
                    docker build -t user-management user-management
                    docker build -t adopt-service adopt-service
                '''
                echo 'Tag & Push Docker images'
                sh '''
                    docker tag user-management $DOCKER_REGISTRY/user-management
                    docker push $DOCKER_REGISTRY/user-management

                    docker tag adopt-service $DOCKER_REGISTRY/adopt-service
                    docker push $DOCKER_REGISTRY/adopt-service
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