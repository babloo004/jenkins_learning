node {
    def ud = input(
        id: 'user_details',
        message: 'user\'s details are stored here',
        parameters: [string(name: 'Name', description: 'Enter your name'),
            string(name: 'age', description: 'Enter your age')
        ]
    )
    
    stage('checking') {
        def age = ud.age as Integer
        if (age >= 18) {
            sh "echo ${ud['Name']} is adult!"
        }else {
            sh "echo ${ud['Name']} is not and adult!"
        }
    }
}