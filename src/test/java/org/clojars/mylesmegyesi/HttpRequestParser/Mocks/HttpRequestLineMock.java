package org.clojars.mylesmegyesi.HttpRequestParser.Mocks;

import org.clojars.mylesmegyesi.HttpRequestParser.HttpRequestLine;

import java.util.HashMap;

/**
 * Author: Myles Megyesi
 */
public class HttpRequestLineMock extends HttpRequestLine {
    public HttpRequestLineMock() {
        super("", "", "", new HashMap<String, Object>());
    }
}
