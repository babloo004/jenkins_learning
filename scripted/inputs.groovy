node {
    def ud = input(
            id: "user_details",
            message: "user enters his details",
            parameters: [string(name: 'first_name', description:'Enter your first name'),
                string(name: 'last_name', description: 'Enter your laste name'),
                choice(name: 'gender', description: 'select your gender', choices: ['male', 'female']),
                string(name: 'nationality', description: 'enter your nationality')
            ]
        )
        
    stage('input') {
        sh """
            echo First Name: ${ud['first_name']}
            echo Last Name: ${ud['last_name']}
            echo Gender: ${ud['gender']}
            echo Nationality: ${ud['nationality']}
        """
    }
}