pipeline {

	agent any

     triggers {
        pollSCM('* * * * *')
    }
	
	environment {
		PROJETC_PATH_BACK = 'ejemplo-rest'
	}

    stages {

        stage('Checkout'){
            steps{
                echo "------------>Checkout<------------"
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: '*/main']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [], 
                    gitTool: 'Default', 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[
                        credentialsId: 'GitHub', 
                        url:'https://github.com/EsCastro89/ic-test'
                    ]]
                ])
            }
        }

        stage('Compile'){
			parallel {
				stage('Compile backend'){
					steps{
						echo "------------>Compilación backend<------------"
						dir("${PROJETC_PATH_BACK}"){
							sh 'chmod +x gradlew'
							sh './gradlew clean build -x test'
						}
					}
				
				}
			}
		}
		
		stage('Test Unitarios -Cobertura'){
			parallel {
				stage('Test- Cobertura backend'){
					steps {
						echo '------------>test backend<------------'
						dir("${PROJETC_PATH_BACK}"){
							sh './gradlew --stacktrace test'
							
						}
					}
				}
			}
		}
		
		stage('Sonar Scanner Coverage') {
            steps{
                echo '------------>Análisis de código estático<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner" 
                }
            }
        }
    }

    post{
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
            mail (to: 'esteban.castro@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}") 
        }
    }
}