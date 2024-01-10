/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.*;

import java.util.List;
import java.util.Set;

import static uk.emarte.regurgitator.core.CoreConfigConstants.*;
import static uk.emarte.regurgitator.core.Log.getLog;
import static uk.emarte.regurgitator.core.XmlConfigUtil.*;
import static uk.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterXmlLoader extends JsonParameterLoader implements XmlLoader<Step> {
    private static final Log log = getLog(JsonParameterXmlLoader.class);

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
        String jsonPath = loadMandatoryStr(element, JSONPATH);
        String source = loadOptionalStr(element, SOURCE);
        String value = loadOptionalStr(element, VALUE);
        String file = loadOptionalStr(element, FILE);
        List<ValueProcessor> processors = loadOptionalValueProcessors(element, 0, allIds);
        return buildJsonParameter(loadId(element, allIds), loadPrototype(element), loadContext(element), source, value, file, processors, jsonPath, log);
    }
}
