pipeline {
    agent any

    stages {
        stage('Get Code') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/ayaMohamed186/LibraryApiProject.git'
            }
        }

        stage('Run Test') {
            steps {
                bat 'newman run "LibraryCollection.postman_collection.json" -e "dev.postman_environment.json" --reporter cli,htmlextra'
            }
        }
    }
}
