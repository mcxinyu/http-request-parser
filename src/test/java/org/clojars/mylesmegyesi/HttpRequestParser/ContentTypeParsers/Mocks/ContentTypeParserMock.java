package org.clojars.mylesmegyesi.HttpRequestParser.ContentTypeParsers.Mocks;

import org.clojars.mylesmegyesi.HttpRequestParser.ContentTypeParser;

import java.io.InputStream;
import java.util.Map;

/**
 * Author: Myles Megyesi
 */
public class ContentTypeParserMock implements ContentTypeParser {

    public boolean canParse = false;
    public int parseCalledCount = 0;

    public ContentTypeParserMock(boolean canParse) {
        this.canParse = canParse;
    }

    public boolean canParseContentType(String contentType) {
        return canParse;
    }

    public Map<String, Object> parse(InputStream inputStream, int contentLength) {
        this.parseCalledCount++;
        return null;
    }
}
