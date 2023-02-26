import hudson.model.*
import jenkins.model.*
pipeline{
  agent any
  options {
    skipDefaultCheckout()
    timestamps()
  }
  parameters {
    string(name: 'inputVersionNumber', defaultValue: "", description: 'Enter the release number. (Example: R18 , R19(REQUIRED)')
    choice(name: 'inputEnvType', choices: "<select>\nDEV\nPROD", description: "Select the environment type (REQUIRED)")
    choice(name: 'inputSrcType', choices: "<select>\nMosaic-services\nvault\nMonitoring ", description: "Select the required Namespace (REQUIRED)")
	  choice(name: 'inputDeployType', choices: "Deploy\nDelete", description: "Select the required Namespace (REQUIRED)")
    string(name: 'inputServiceList', defaultValue: "", description: 'Enter the will deploy sefvice-list need to deploy, enter comma separated list of each names, like notebook-api,notbook-beat')
    string(name: 'inputProjectName', defaultValue: "MRM", description: 'Project Name')
    string(name: 'inputDefectOrCR/JiraNo', defaultValue: "None", description: 'Change & Jira:no ')
    string(name: 'inputRequesterName', defaultValue: "Mosaic-admin", description: 'Enter the requester name')
	}
  stages{
    stage('Loading groovy file'){
      steps{
        script{
            dir('Deployment') { 
              //checkout scm
		    props = readYaml file: 'project.yaml'
		    stash includes: "project.yaml", name: 'AppStash'
	    }
            first = load './first.groovy' 
            first.runPipeline(props)   
        }
      }
    }
  }
 }
