package motion.blevast.parser.task;

/**
 * Process the vast
 */

public class ProcessVast extends ManualValidateVast {

    private String report;

    //This checks the minimum requirements to play the video
    @Override
    public void useSelectedValuesForValidation(String response) {
        //Minimum requirements for VAST
        //TODO:: ideally we can use xpath for validation and its valid for this purpose
        //TODO:: for now we will just process it and see if the required elements 're there
        processVast(response);
    }

    //This is when the vast is valid from the XSD point of view
    @Override
    public void processVast(String  response) {
        //
    }

    @Override
    public void onXSDValidationReport(String report) {
        //Set the report value on the XSD
        this.report = report;
    }
}
