
//This is future project for parsing XML
function VastParser(xmlString) {

    //Log out the xml string to the console
    console.log(xmlString);

    VastParser.prototype.setVastParserClient = function(vastParserClient) {
        this._vastParserClient = vastParserClient;
    }

    VastParser.prototype.parseAd = function() {
        //Extract the <VAST> params here.
    }

}

initParser = function(xmlString) {
    //Init the vast parser
    vastParserInstance = new VastParser(xmlString);
    vastParserInstance.setVastParserClient(mobile);
    mobile.onClientSet();
    vastParserInstance.parseAd();
}
