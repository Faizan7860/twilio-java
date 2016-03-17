package com.twilio.sdk.updaters.api.v2010.account;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.Promoter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.api.v2010.account.Application;
import com.twilio.sdk.updaters.Updater;

import java.net.URI;

public class ApplicationUpdater extends Updater<Application> {
    private final String accountSid;
    private final String sid;
    private String friendlyName;
    private String apiVersion;
    private URI voiceUrl;
    private HttpMethod voiceMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private Boolean voiceCallerIdLookup;
    private URI smsUrl;
    private HttpMethod smsMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsFallbackMethod;
    private URI smsStatusCallback;
    private URI messageStatusCallback;

    /**
     * Construct a new ApplicationUpdater.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     */
    public ApplicationUpdater(final String accountSid, 
                              final String sid) {
        this.accountSid = accountSid;
        this.sid = sid;
    }

    /**
     * A human readable descriptive text for this resource, up to 64 characters
     * long..
     * 
     * @param friendlyName Human readable description of this resource
     * @return this
     */
    public ApplicationUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Requests to this application will start a new TwiML session with this API
     * version..
     * 
     * @param apiVersion The API version to use
     * @return this
     */
    public ApplicationUpdater setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * The URL Twilio will request when a phone number assigned to this application
     * receives a call..
     * 
     * @param voiceUrl URL Twilio will make requests to when relieving a call
     * @return this
     */
    public ApplicationUpdater setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The URL Twilio will request when a phone number assigned to this application
     * receives a call..
     * 
     * @param voiceUrl URL Twilio will make requests to when relieving a call
     * @return this
     */
    public ApplicationUpdater setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    /**
     * The HTTP method Twilio will use when requesting the above `Url`. Either `GET`
     * or `POST`..
     * 
     * @param voiceMethod HTTP method to use with the URL
     * @return this
     */
    public ApplicationUpdater setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * The URL that Twilio will request if an error occurs retrieving or executing
     * the TwiML requested by `Url`..
     * 
     * @param voiceFallbackUrl Fallback URL
     * @return this
     */
    public ApplicationUpdater setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * The URL that Twilio will request if an error occurs retrieving or executing
     * the TwiML requested by `Url`..
     * 
     * @param voiceFallbackUrl Fallback URL
     * @return this
     */
    public ApplicationUpdater setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    /**
     * The HTTP method Twilio will use when requesting the `VoiceFallbackUrl`.
     * Either `GET` or `POST`..
     * 
     * @param voiceFallbackMethod HTTP method to use with the fallback url
     * @return this
     */
    public ApplicationUpdater setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * The URL that Twilio will request to pass status parameters (such as call
     * ended) to your application..
     * 
     * @param statusCallback URL to hit with status updates
     * @return this
     */
    public ApplicationUpdater setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL that Twilio will request to pass status parameters (such as call
     * ended) to your application..
     * 
     * @param statusCallback URL to hit with status updates
     * @return this
     */
    public ApplicationUpdater setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method Twilio will use to make requests to the `StatusCallback` URL.
     * Either `GET` or `POST`..
     * 
     * @param statusCallbackMethod HTTP method to use with the status callback
     * @return this
     */
    public ApplicationUpdater setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * Look up the caller's caller-ID name from the CNAM database (additional
     * charges apply). Either `true` or `false`..
     * 
     * @param voiceCallerIdLookup True or False
     * @return this
     */
    public ApplicationUpdater setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    /**
     * The URL Twilio will request when a phone number assigned to this application
     * receives an incoming SMS message..
     * 
     * @param smsUrl URL Twilio will request when receiving an SMS
     * @return this
     */
    public ApplicationUpdater setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The URL Twilio will request when a phone number assigned to this application
     * receives an incoming SMS message..
     * 
     * @param smsUrl URL Twilio will request when receiving an SMS
     * @return this
     */
    public ApplicationUpdater setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    /**
     * The HTTP method Twilio will use when making requests to the `SmsUrl`. Either
     * `GET` or `POST`..
     * 
     * @param smsMethod HTTP method to use with sms_url
     * @return this
     */
    public ApplicationUpdater setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * The URL that Twilio will request if an error occurs retrieving or executing
     * the TwiML from `SmsUrl`..
     * 
     * @param smsFallbackUrl Fallback URL if there's an error parsing TwiML
     * @return this
     */
    public ApplicationUpdater setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * The URL that Twilio will request if an error occurs retrieving or executing
     * the TwiML from `SmsUrl`..
     * 
     * @param smsFallbackUrl Fallback URL if there's an error parsing TwiML
     * @return this
     */
    public ApplicationUpdater setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    /**
     * The HTTP method Twilio will use when requesting the above URL. Either `GET`
     * or `POST`..
     * 
     * @param smsFallbackMethod HTTP method to use with sms_fallback_method
     * @return this
     */
    public ApplicationUpdater setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * The URL that Twilio will `POST` to when a message is sent via the
     * `/SMS/Messages` endpoint if you specify the `Sid` of this application on an
     * outgoing SMS request..
     * 
     * @param smsStatusCallback URL Twilio with request with status updates
     * @return this
     */
    public ApplicationUpdater setSmsStatusCallback(final URI smsStatusCallback) {
        this.smsStatusCallback = smsStatusCallback;
        return this;
    }

    /**
     * The URL that Twilio will `POST` to when a message is sent via the
     * `/SMS/Messages` endpoint if you specify the `Sid` of this application on an
     * outgoing SMS request..
     * 
     * @param smsStatusCallback URL Twilio with request with status updates
     * @return this
     */
    public ApplicationUpdater setSmsStatusCallback(final String smsStatusCallback) {
        return setSmsStatusCallback(Promoter.uriFromString(smsStatusCallback));
    }

    /**
     * Twilio will make a `POST` request to this URL to pass status parameters (such
     * as sent or failed) to your application if you use the `/Messages` endpoint to
     * send the message and specify this application's `Sid` as the `ApplicationSid`
     * on an outgoing SMS request..
     * 
     * @param messageStatusCallback URL to make requests to with status updates
     * @return this
     */
    public ApplicationUpdater setMessageStatusCallback(final URI messageStatusCallback) {
        this.messageStatusCallback = messageStatusCallback;
        return this;
    }

    /**
     * Twilio will make a `POST` request to this URL to pass status parameters (such
     * as sent or failed) to your application if you use the `/Messages` endpoint to
     * send the message and specify this application's `Sid` as the `ApplicationSid`
     * on an outgoing SMS request..
     * 
     * @param messageStatusCallback URL to make requests to with status updates
     * @return this
     */
    public ApplicationUpdater setMessageStatusCallback(final String messageStatusCallback) {
        return setMessageStatusCallback(Promoter.uriFromString(messageStatusCallback));
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Application
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Application execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.accountSid + "/Applications/" + this.sid + ".json",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Application update failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_OK) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Application.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
        }
        
        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());
        }
        
        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());
        }
        
        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());
        }
        
        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());
        }
        
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }
        
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }
        
        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());
        }
        
        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
        }
        
        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
        }
        
        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
        }
        
        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
        }
        
        if (smsStatusCallback != null) {
            request.addPostParam("SmsStatusCallback", smsStatusCallback.toString());
        }
        
        if (messageStatusCallback != null) {
            request.addPostParam("MessageStatusCallback", messageStatusCallback.toString());
        }
    }
}