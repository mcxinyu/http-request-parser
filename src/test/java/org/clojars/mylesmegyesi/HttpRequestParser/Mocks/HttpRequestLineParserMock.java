package org.clojars.mylesmegyesi.HttpRequestParser.Mocks;

import org.clojars.mylesmegyesi.HttpRequestParser.ContentTypeParsers.UrlEncodedFormParser;
import org.clojars.mylesmegyesi.HttpRequestParser.HttpRequestLine;
import org.clojars.mylesmegyesi.HttpRequestParser.HttpRequestLineParser;
import org.clojars.mylesmegyesi.HttpRequestParser.Utility.InputStreamReader;

import java.io.InputStream;

/**
 * Author: Myles Megyesi
 */
public class HttpRequestLineParserMock extends HttpRequestLineParser {

    public int parseCalledCount = 0;

    public HttpRequestLineParserMock() {
        super(new InputStreamReader(), new UrlEncodedFormParser());
    }

    @Override
    public HttpRequestLine parse(InputStream inputStream) {
        this.parseCalledCount++;
        return new HttpRequestLineMock();
    }
}
