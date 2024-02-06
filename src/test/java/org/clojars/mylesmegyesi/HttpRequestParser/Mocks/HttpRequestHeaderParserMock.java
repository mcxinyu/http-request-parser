package org.clojars.mylesmegyesi.HttpRequestParser.Mocks;

import org.clojars.mylesmegyesi.HttpRequestParser.HttpRequestHeadersParser;
import org.clojars.mylesmegyesi.HttpRequestParser.Utility.InputStreamReader;

import java.io.InputStream;
import java.util.Map;

/**
 * Author: Myles Megyesi
 */
public class HttpRequestHeaderParserMock extends HttpRequestHeadersParser {

    public int parseCalledCount = 0;

    public HttpRequestHeaderParserMock() {
        super(new InputStreamReader());
    }

    @Override
    public Map<String, String> parse(InputStream inputStream) {
        this.parseCalledCount++;
        return null;
    }
}
