package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterXmlLoader extends JsonParameterLoader implements XmlLoader<Step> {
    private static final Log log = getLog(JsonParameterXmlLoader.class);

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
		String jsonPath = element.attributeValue(JSONPATH);
		String source = element.attributeValue(SOURCE);
		String value = element.attributeValue(VALUE);
		String file = element.attributeValue(FILE);
		ValueProcessor processor = loadOptionalValueProcessor(element, 0, allIds);
		return buildJsonParameter(loadId(element, allIds), loadPrototype(element), loadContext(element), source, value, file, processor, jsonPath, log);
    }
}
