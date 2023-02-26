import hudson.model.*
import jenkins.model.*
pipeline{
  agent any
  options {
    skipDefaultCheckout()
    timestamps()
  }
  parameters {
    string(name: 'inputVersionNumber', defaultValue: "R22", description: 'Enter the release number. (Example: R18 , R19(REQUIRED)')
    choice(name: 'inputEnvType', choices: "DEV\nPROD", description: "Select the environment type (REQUIRED)")
    choice(name: 'inputSrcType', choices: "Mosaic-services\nvault\nMonitoring ", description: "Select the required Namespace (REQUIRED)")
    choice(name: 'inputDeployType', choices: "Deploy\nDelete", description: "Select the required Namespace (REQUIRED)")
    string(name: 'inputServiceList', defaultValue: "", description: 'Enter the will deploy sefvice-list need to deploy, enter comma separated list of each names, like notebook-api,notbook-beat')	}
  stages{
    stage('Loading groovy file'){
      steps{
        script{
            dir('Deployment') { 
              //checkout scm
		    //git branch: 'main',
		    //url: 'git@github.com:shanmugamnsw/test.git'
		    sh "ls -lat"
		    sh "cd /var/jenkins_home/workspace/deploy/Deployment/"
		    props = readYaml file: 'project.yaml'
		    stash includes: "project.yaml", name: 'AppStash'
		    //first = load'/var/jenkins_home/workspace/deploy/Deployment/deploy.groovy' 
                    //first.runPipeline(props)
	    }
        }
      }
    }
  }
 }
