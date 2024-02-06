package org.clojars.mylesmegyesi.HttpRequestParser;

import org.clojars.mylesmegyesi.HttpRequestParser.Exceptions.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Author: Myles Megyesi
 */
public interface ContentTypeParser {

    public boolean canParseContentType(String contentType);

    public Map<String, Object> parse(InputStream inputStream, int contentLength) throws ParseException, IOException;
}
