pipeline {

    agent any

    environment {
        DB_URL = credentials('db-url')
        DB_USER = credentials('db-user')
        DB_PWD = credentials('db-password')
    }

    stages {

        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
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
                  -p 8081:8080 \
                  -e DB_URL="$DB_URL" \
                  -e DB_USER="$DB_USER" \
                  -e DB_PWD="$DB_PWD" \
                  fitness-monolith:0.0.1-SNAPSHOT
                '''
            }
        }
    }
}