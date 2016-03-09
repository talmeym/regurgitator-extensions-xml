package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.Log.getLog;

public class JsonPathProcessorXmlLoader implements XmlLoader<JsonPathProcessor> {
	private static final Log log = getLog(JsonPathProcessor.class);

	@Override
	public JsonPathProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded json path processor");
		return new JsonPathProcessor(element.getText());
	}
}
