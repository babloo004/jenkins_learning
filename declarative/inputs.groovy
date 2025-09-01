pipeline {
    agent any
    parameters {
        string(name: 'first_name', description: 'enter your first name')
        string(name: 'last_name', description: 'enter your last name')
        choice(name: 'gender', description: 'select your gender', choices: ['male','female','prefer not to say'])
        string(name: 'nationality', description: 'enter your nationality')
    }
    
    stages {
        
        stage('input testing') {
            
            steps {
                sh """
                    echo First Name: ${params.first_name}
                    echo Last Name: ${params.last_name}
                    echo Gender: ${params.gender}
                    echo Nationality: ${params.nationality}
                """
            }
        }
    }
}