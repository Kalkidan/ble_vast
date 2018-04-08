VerveVPAIDWrapper = function() {
    //A standard function that will
    //be implemented within the JS for
    //VPAID
    this._creative = getVPAIDAd();
    this.timer = null;
    //Sets the Vpaid Android client
    VerveVPAIDWrapper.prototype.setVpaidClient = function(vpaidClient) {
        this._vpaidClient = vpaidClient;
    }
    VerveVPAIDWrapper.prototype.handshakeVersion = function(version) {
        var result = this._creative.handshakeVersion(version);
        android.handshakeVersionResult(result);
        return result;
    }
    VerveVPAIDWrapper.prototype.initAdWrapper = function(width, height, desiredBitrate, creativeData, environmentVars) {
         this._vpaidClient.initAdResult();
         console.log(environmentVars);
         this._creative.initAd(width, height, 'normal', desiredBitrate, creativeData, environmentVars);
    };
    VerveVPAIDWrapper.prototype.onAdPaused = function() {
        console.log("onAdPaused");
        this._vpaidClient.vpaidAdPaused();
    };
    VerveVPAIDWrapper.prototype.onAdPlaying = function() {
        console.log("onAdPlaying");
        this._vpaidClient.vpaidAdPlaying();
    };
    VerveVPAIDWrapper.prototype.onAdError = function(message) {
        console.log("onAdError: " + message);
        this._vpaidClient.vpaidAdError(message);
    };
    VerveVPAIDWrapper.prototype.onAdLog = function(message) {
        console.log("onAdLog: " + message);
        this._vpaidClient.vpaidAdLog(message);
    };
    VerveVPAIDWrapper.prototype.onAdUserAcceptInvitation = function() {
        console.log("onAdUserAcceptInvitation");
        this._vpaidClient.vpaidAdUserAcceptInvitation();
    };
    VerveVPAIDWrapper.prototype.onAdUserMinimize = function() {
        console.log("onAdUserMinimize");
        this._vpaidClient.vpaidAdUserMinimize();
    };
    VerveVPAIDWrapper.prototype.onAdUserClose = function() {
        console.log("onAdUserClose");
        this._vpaidClient.vpaidAdUserClose();
    };
    VerveVPAIDWrapper.prototype.onAdSkippableStateChange = function() {
        console.log("Ad Skippable State Changed to: " + this._creative.getAdSkippableState());
        this._vpaidClient.vpaidAdSkippableStateChange();
    };
    VerveVPAIDWrapper.prototype.onAdExpandedChange = function() {
        console.log("Ad Expanded Changed to: " + this._creative.getAdExpanded());
        this._vpaidClient.vpaidAdExpandedChange();
    };
    VerveVPAIDWrapper.prototype.getAdExpanded = function() {
        console.log("getAdExpanded");
        var result = this._creative.getAdExpanded();
        android.getAdExpandedResult(result);
    };
    VerveVPAIDWrapper.prototype.getAdSkippableState = function() {
        console.log("getAdSkippableState");
        var result = this._creative.getAdSkippableState();
        android.getAdSkippableStateResult(result);
    };
    VerveVPAIDWrapper.prototype.onAdSizeChange = function() {
        console.log("Ad size changed to: w=" + this._creative.getAdWidth() + " h=" + this._creative.getAdHeight());
        this._vpaidClient.vpaidAdSizeChange();
    };
    VerveVPAIDWrapper.prototype.onAdDurationChange = function() {
        if (this.handshakeVersion() >= 2) {
        }
        this._vpaidClient.vpaidAdDurationChange();
    };
    VerveVPAIDWrapper.prototype.onAdRemainingTimeChange = function() {
        if (this.handshakeVersion() < 2) {
        }
        this._vpaidClient.vpaidAdRemainingTimeChange();
    };
    VerveVPAIDWrapper.prototype.getAdRemainingTime = function() {
        console.log("getAdRemainingTime");
        var result = this._creative.getAdRemainingTime();
        android.getAdRemainingTimeResult(result);
    };
    VerveVPAIDWrapper.prototype.onAdImpression = function() {
        console.log("Ad Impression");
        this._vpaidClient.vpaidAdImpression();
    };
    VerveVPAIDWrapper.prototype.onAdClickThru = function(url, id, playerHandles) {
        console.log("Clickthrough portion of the ad was clicked");
        var adjustedUrl = url;
        if (adjustedUrl == undefined)
            adjustedUrl = ""
        this._vpaidClient.vpaidAdClickThruIdPlayerHandles(adjustedUrl, id, playerHandles);
    };
    VerveVPAIDWrapper.prototype.onAdInteraction = function(id) {
        console.log("A non-clickthrough event has occured");
        this._vpaidClient.vpaidAdInteraction(id);
    };
    VerveVPAIDWrapper.prototype.onAdVideoStart = function() {
        console.log("Video 0% completed");
        this._vpaidClient.vpaidAdVideoStart();
    };
    VerveVPAIDWrapper.prototype.onAdVideoFirstQuartile = function() {
        console.log("Video 25% completed");
        this._vpaidClient.vpaidAdVideoFirstQuartile();
    };
    VerveVPAIDWrapper.prototype.onAdVideoMidpoint = function() {
        console.log("Video 50% completed");
        this._vpaidClient.vpaidAdVideoMidpoint();
    };
    VerveVPAIDWrapper.prototype.onAdVideoThirdQuartile = function() {
        console.log("Video 75% completed");
        this._vpaidClient.vpaidAdVideoThirdQuartile();
    };
    VerveVPAIDWrapper.prototype.onAdVideoComplete = function() {
        console.log("Video 100% completed");
        this._vpaidClient.vpaidAdVideoComplete();
    };
    VerveVPAIDWrapper.prototype.onAdLinearChange = function() {
        console.log("Ad linear has changed: " + this._creative.getAdLinear());
        this._vpaidClient.vpaidAdLinearChange();
    };
    VerveVPAIDWrapper.prototype.getAdLinear = function() {
        console.log("getAdLinear");
        var result = this._creative.getAdLinear();
        android.getAdLinearResult(result);
    };
    VerveVPAIDWrapper.prototype.getAdDuration = function() {
        console.log("getAdDuration");
        var result = this._creative.getAdDuration();
        android.getAdDurationResult(result);
    };
    VerveVPAIDWrapper.prototype.onAdLoaded = function() {
        console.log("ad has been loaded");
        this._vpaidClient.vpaidAdLoaded();
    };
    VerveVPAIDWrapper.prototype.onAdStarted = function() {
        console.log("Ad has started");
        this._vpaidClient.vpaidAdStarted();
    };
    VerveVPAIDWrapper.prototype.onAdStopped = function() {
        console.log("Ad has stopped");
        clearInterval(this.timer);
        this._vpaidClient.vpaidAdStopped();
    };
    VerveVPAIDWrapper.prototype.onAdSkipped = function() {
        console.log("Ad was skipped");
        this._creative.stopAd();
        this._vpaidClient.vpaidAdSkipped();
    };
    VerveVPAIDWrapper.prototype.setAdVolume = function(val) {
        this._creative.setAdVolume(val);
    };
    VerveVPAIDWrapper.prototype.getAdVolume = function() {
        var result = this._creative.getAdVolume();
        android.getAdVolumeResult(result);
    };
    VerveVPAIDWrapper.prototype.onAdVolumeChange = function() {
        console.log("Ad Volume has changed to - " + this._creative.getAdVolume());
        this._vpaidClient.vpaidAdVolumeChanged();
    };
    VerveVPAIDWrapper.prototype.replay = function() {
            //this._ui.createProgressBar();
            this.setCallbacksForCreative();
             this._vpaidClient.vpaidReplaySet();
    };
    VerveVPAIDWrapper.prototype.startAd = function() {
        //this._ui.createProgressBar();
        this._creative.startAd();
    };
    VerveVPAIDWrapper.prototype.skipAd = function() {
        this._creative.skipAd();
    };
    VerveVPAIDWrapper.prototype.stopAd = function() {
        this._creative.stopAd();
    };
    VerveVPAIDWrapper.prototype.resizeAd = function(width, height, viewMode) {
        this._creative.resizeAd(width, height, viewMode);
    };
    VerveVPAIDWrapper.prototype.pauseAd = function() {
        this._creative.pauseAd();
    };
    VerveVPAIDWrapper.prototype.resumeAd = function() {
        this._creative.resumeAd();
    };
    VerveVPAIDWrapper.prototype.expandAd = function() {
        this._creative.expandAd();
    };
    VerveVPAIDWrapper.prototype.collapseAd = function() {
        this._creative.collapseAd();
    };
    VerveVPAIDWrapper.prototype.setCallbacksForCreative = function() {
        var callbacks = {
            'AdStarted': this.onAdStarted,
            'AdVideoStart': this.onAdVideoStart,
            'AdVideoFirstQuartile': this.onAdVideoFirstQuartile,
            'AdVideoMidpoint': this.onAdVideoMidpoint,
            'AdVideoThirdQuartile': this.onAdVideoThirdQuartile,
            'AdVideoComplete': this.onAdVideoComplete,
            'AdStopped': this.onAdStopped,
            'AdSkipped': this.onAdSkipped,
            'AdLoaded': this.onAdLoaded,
            'AdLinearChange': this.onAdLinearChange,
            'AdSizeChange': this.onAdSizeChange,
            'AdExpandedChange': this.onAdExpandedChange,
            'AdSkippableStateChange': this.onAdSkippableStateChange,
            'AdDurationChange': this.onAdDurationChange,
            'AdRemainingTimeChange': this.onAdRemainingTimeChange,
            'AdVolumeChange': this.onAdVolumeChange,
            'AdImpression': this.onAdImpression,
            'AdClickThru': this.onAdClickThru,
            'AdInteraction': this.onAdInteraction,
            'AdUserAcceptInvitation': this.onAdUserAcceptInvitation,
            'AdUserMinimize': this.onAdUserMinimize,
            'AdUserClose': this.onAdUserClose,
            'AdPaused': this.onAdPaused,
            'AdPlaying': this.onAdPlaying,
            'AdError': this.onAdError,
            'AdLog': this.onAdLog

        };
      
       if (typeof this._creative.subscribe === 'function') {
           console.log("Subscribe function is found");
           for (var eventName in callbacks) {
               this._creative.subscribe(callbacks[eventName], eventName, this);
           }
       } else {
           console.log("This VPAID didn't have any subscribe function defined");
       }
        
    };
};

initVpaidWrapper = function() {

    //Provides new instance of the JS object
    //using the standard getVPAIDAd()
    verveVPAIDWrapperInstance = new VerveVPAIDWrapper();
    //Sets the creative callbacks
    verveVPAIDWrapperInstance.setCallbacksForCreative();
    //sets the vpaid client -- which is android in our case
    verveVPAIDWrapperInstance.setVpaidClient(android);
    //wrapper is ready so signal into the
    //...webview, this is listened within the webview
    android.wrapperReady();
}
