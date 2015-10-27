package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.XmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.JSONPATH;

public class JsonParameterXmlLoader implements XmlLoader<Step> {
    private static final Log log = Log.getLog(JsonParameterXmlLoader.class);

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
        String id = loadId(element, allIds);
		String jsonPath = element.attributeValue(JSONPATH);
		ValueProcessor processor = loadOptionalValueProcessor(element, allIds);

		log.debug("Loaded json parameter '" + id + '\'');
        return new JsonParameter(id, loadPrototype(element), loadContext(element), loadContextLocation(element), new JsonPathProcessor(jsonPath), processor);
    }
}
