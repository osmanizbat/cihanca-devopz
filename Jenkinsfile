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

        stage('Deploy') {
            steps {
                echo 'Deploying....'

                sh '''
                    scp -o StrictHostKeyChecking=no docker-compose.yaml nginx.conf jenkins@$APP_SERVER:/opt/$PROJECT_NAME
                    ssh jenkins@$APP_SERVER docker-compose -f /opt/$PROJECT_NAME/docker-compose.yaml pull
                    ssh jenkins@$APP_SERVER docker-compose -f /opt/$PROJECT_NAME/docker-compose.yaml up -d
                '''
            }
        }
    }
}