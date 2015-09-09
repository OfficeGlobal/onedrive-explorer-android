package com.microsoft.onedriveaccess;

import com.microsoft.onedriveacess.BuildConfig;
import com.microsoft.services.msa.LiveAuthClient;

import retrofit.RequestInterceptor;

/**
 * Produces Request interceptor for OneDrive service requests
 */
final class InterceptorFactory {

    /**
     * Default Constructor
     */
    private InterceptorFactory() {
    }

    /**
     * Creates an instance of the request interceptor
     * @param authClient The credentials used by the interceptor
     * @return The interceptor object
     */
    public static RequestInterceptor getRequestInterceptor(final LiveAuthClient authClient) {
        return new RequestInterceptor() {

            @Override
            public void intercept(final RequestFacade request) {
                request.addHeader("Authorization", "bearer " + authClient.getSession().getAccessToken());
                request.addHeader("User-Agent", "OneDriveSDK Android " + BuildConfig.VERSION_NAME);
            }
        };
    }
}
