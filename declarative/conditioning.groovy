pipeline {
    agent any
    parameters {
        string(name:'name',description:'enter your name')
        string(name:'age',description:'enter your age', defaultValue: '0')
    }
    
    stages{
        
        stage('setting env variables') {
            steps {
                script {
                    def ageInt = params.age as Integer
                    env.age = ageInt.toString()
                }
            }
        }
        stage('conditioning') {
            when {
                allOf {
                    expression {env.age.toInteger() >= 18 }
                }
            }
            steps {
                sh "echo ${params.name} is an adult!"
            }
        }
    }
}