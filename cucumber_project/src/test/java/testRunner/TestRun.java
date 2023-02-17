package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

// if there is any error, check for the packages imported(Different from video)
// all the annotations mentioned below are kind of mandatory 

@RunWith(Cucumber.class)
@CucumberOptions
		(
		features = {".//Features/"},   // where the feature files are located
		glue = "stepDefinitions", 				  	  // where the step files are located
		dryRun = false,							  	  // check before execution whether all Feature files have corresponding steps implemented or not
		monochrome = true,						  	  // remove unnecessary character in the console window
		//publish = true,
		plugin = {"pretty", "html:target/cucumber-reports/test-output.html"} // generate report and create a new folder:test-output
		//tags = @sanity or @regression							  // runs the test cases on the basis of tags
		)

		// tags = "@sanity" , "@regression" means the test case should be part of both the tags(and condition)
		// tags = "@sanity , @regression" means the test case can be part of either of the two tags(or condition)

public class TestRun {

}
