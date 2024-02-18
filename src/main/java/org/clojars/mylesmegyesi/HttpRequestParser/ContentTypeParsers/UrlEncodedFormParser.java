package org.clojars.mylesmegyesi.HttpRequestParser.ContentTypeParsers;

import org.clojars.mylesmegyesi.HttpRequestParser.ContentTypeParser;
import org.clojars.mylesmegyesi.HttpRequestParser.Exceptions.ParseException;
import org.clojars.mylesmegyesi.HttpRequestParser.Utility.InputStreamReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Myles Megyesi
 */
public class UrlEncodedFormParser implements ContentTypeParser {

    public InputStreamReader inputStreamReader;

    public UrlEncodedFormParser() {
        this.inputStreamReader = new InputStreamReader();
    }

    public boolean canParseContentType(String contentType) {
        return contentType.equals("application/x-www-form-urlencoded");
    }

    public Map<String, Object> parse(InputStream inputStream, int contentLength) throws IOException, ParseException {
        String query = URLDecoder.decode(this.inputStreamReader.read(inputStream, contentLength), "UTF-8");
        String[] stringParams = query.split("&");
        return parseParams(query, stringParams);
    }

    private Map<String, Object> parseParams(String query, String[] stringParams) throws ParseException {
        Map<String, Object> params = new HashMap<String, Object>();
        for (String stringParam : stringParams) {
            if (!query.equals("")) {
                try {
                    // 有一种情况：参数有可能没有值，只是为了避免浏览器缓存而已
                    String[] param = this.parseParam(stringParam);
                    params.put(param[0], param[1]);
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        }
        return params;
    }

    private String[] parseParam(String query) throws ParseException {
        int index = query.indexOf("=");
        if (index == -1 || index == 0) {
            throw new ParseException("Improperly formatted query string " + query);
        }
        return new String[]{query.substring(0, index), query.substring(index + 1, query.length())};
    }
}
