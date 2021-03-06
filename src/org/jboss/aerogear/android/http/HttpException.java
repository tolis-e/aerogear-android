/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.aerogear.android.http;

import java.util.Arrays;

/**
 * If an HTTP Request does not return status code 200 then this will
 * be thrown.
 */
public class HttpException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "The server returned the error code %d.";

    /**
     * The body of the http response.
     */
    private final byte[] data;

    /**
     * The returned status code
     */
    private final int statusCode;

    public HttpException(byte[] data, int statusCode) {
        this(data, statusCode, String.format(DEFAULT_MESSAGE, statusCode));
    }

    public HttpException(byte[] data, int statusCode, String message) {
        super(message);
        this.data = data;
        this.statusCode = statusCode;
    }

    public byte[] getData() {
        return Arrays.copyOf(data, data.length);
    }

    public int getStatusCode() {
        return statusCode;
    }

}
