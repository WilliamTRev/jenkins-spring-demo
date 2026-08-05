pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'spring-boot-app'
        APP_NAME = 'spring-boot-container'
    }

    stages {
		stage('Build Maven') {
			steps {
                 
                    sh 'chmod +x mvnw'
                    sh './mvnw clean package '
                
            }
		}
        stage('Docker Build') {
            steps {
					
                    sh "docker build -t ${DOCKER_IMAGE} ."
                
            }
        }
        stage('Deploy'){
            steps {
                sh "docker rm -f ${APP_NAME} || true"
				
				sh "docker rm -f prometheus || true"
				sh "docker rm -f grafana || true"
			
                sh "docker network create jenkins-demo-net || true"
                sh "docker run -d -p 8081:8080 --network jenkins-demo-net --name ${APP_NAME} ${DOCKER_IMAGE}"
				sh "ls -la ${WORKSPACE}"
				sh "docker run -d --name prometheus --network jenkins-demo-net -p 9090:9090 -v ${WORKSPACE}/prometheus:/etc/prometheus prom/prometheus"

				sh "docker run -d --name grafana --network jenkins-demo-net -p 3000:3000 grafana/grafana"
            }
        }
    }
}