package motion.blevast.parser.task;

import android.text.TextUtils;
import android.util.Log;

import motion.blevast.parser.parser.XmlParser;
import motion.blevast.parser.util.VastUtil;
import motion.blevast.parser.vast.Vast;
import motion.blevast.parser.vastad.VastParser;
import motion.blevast.parser.vastad.model.VastData;

/**
 * Process the vast
 */

public class ProcessVast extends ManualValidateVast {

    private final String TAG = ProcessVast.class.getSimpleName();

    private String report;
    private int wrapperHitCount;

    //This checks the minimum requirements to play the video
    @Override
    public void useSelectedValuesForValidation(String response) {
        //Minimum requirements for VAST
        //TODO:: ideally we can use xpath for validation and its valid for this purpose
        //TODO:: for now we will just process it and see if the required elements 're there
        processVast(response);
    }

    //Process the vast
    @Override
    public void processVast(String  response) {
        //Start processing the String response
        if(!TextUtils.isEmpty(response)){
            Vast vast;

            try {
                vast = XmlParser.parse(response, Vast.class);
                if(vast.getStatus() != null){
                    Log.d(TAG, "VAST has a problem");
                    //Incoming VAST has a problem

                } else {
                    if(vast.getAd() == null || vast.getAd().isEmpty()){
                        Log.d(TAG, "There is no AD to fill");
                        //Spit out the error
                        getUsecaseCallback().onError(new Error("There is no Ad to fill in here."));
                        return;
                    } else {
                        //
                        VastParser builder = vast.getBuilder().
                                parseVast().
                                build();
                        //
                        VastData vastData = builder.getVastData();
                        //
                        VastUtil.storeVastData(vastData);
                        //
                        getUsecaseCallback().onSuccess(new ResponseValues(vastData, getRequestValues().getContext(), wrapperHitCount));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                getUsecaseCallback().onError(new Error(e.getMessage()));
            }


        } else {
            //TODO:: this is not going to happen, but, better guard it than not.
        }

    }

    @Override
    public void onXSDValidationReport(String report) {
        //Set the report value on the XSD
        this.report = report;
    }
}
