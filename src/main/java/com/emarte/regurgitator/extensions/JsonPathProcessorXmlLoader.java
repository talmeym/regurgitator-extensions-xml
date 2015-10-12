package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

public class JsonPathProcessorXmlLoader implements XmlLoader<ValueProcessor> {
	private static final Log log = Log.getLog(JsonPathProcessor.class);

	@Override
	public JsonPathProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded json path processor");
		return new JsonPathProcessor(element.getText());
	}
}
