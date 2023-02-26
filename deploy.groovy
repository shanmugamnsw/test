import com.cloudbees.groovy.cps.NonCPS
import groovy.transform.Field
import java.text.SimpleDateFormat


/*----------------------------------------------------------------------------------------------------------------------
  DEPLOY PIPELINE
  --------------------------------------------------------------------------------------------------------------------*/
@NonCPS
def runPipeline(run) {

     
     dir('Deployment') {
	     if(env.inputEnvType.startsWith("STAGE") && (env.inputDeployType == "DEPLOY")){
             echo  "Deployment is going to run in Staging environments ."      
	     }
	     if(env.inputEnvType.startsWith ("<select>") || (env.inputDeployType == "<select>")){
		     error "Kindly select the environment."
	     }
         if(env.inputEnvType.startsWith ("PROD") && (env.inputSrcType == "Mosaic-services")){
		     echo "Deployment is going to run in Prod-environments in Mosaic-services ." 
     }
     }
     
             stage('checking'){
             } 
        envNamesSplit = env.inputServiceList.tokenize(",");
        for (i = 0; i < inputServiceList.size();i++) {
          if (env.inputEnvType == "STAGE"( envNamesSplit[i] )){
            //if a custom inputEnvnameList is given in input, check if currentEnv name is present in that list.
            envMatches = true
          }
       }
   
  }

return this;
