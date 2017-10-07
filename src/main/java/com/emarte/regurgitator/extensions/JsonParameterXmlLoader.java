/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterXmlLoader extends JsonParameterLoader implements XmlLoader<Step> {
    private static final Log log = getLog(JsonParameterXmlLoader.class);

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
        String jsonPath = getAttribute(element, JSONPATH);
        String source = getAttribute(element, SOURCE);
        String value = getAttribute(element, VALUE);
        String file = getAttribute(element, FILE);
        ValueProcessor processor = loadOptionalValueProcessor(element, 0, allIds);
        return buildJsonParameter(loadId(element, allIds), loadPrototype(element), loadContext(element), source, value, file, processor, jsonPath, log);
    }
}
