pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh './mvnw spring-boot:build-image'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop fitness-monolith-container || true
                docker rm fitness-monolith-container || true

                docker run -d \
                  --name fitness-monolith-container \
                  -p 8080:8080 \
                  -e DB_URL=jdbc:mysql://host.docker.internal:3306/fitnessTracker \
                  -e DB_USER=root \
                  -e DB_PWD=Tejasvi@786 \
                  fitness-monolith:0.0.1-SNAPSHOT
                '''
            }
        }
    }
}