package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.XmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;

public class XmlParameterXmlLoader extends XmlParameterLoader implements XmlLoader<Step> {
    private static final Log log = Log.getLog(XmlParameter.class);
	private static final XpathProcessorXmlLoader XPATH_LOADER = new XpathProcessorXmlLoader();

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
		XpathProcessor xpathProcessor = XPATH_LOADER.load(element, allIds);
		String source = element.attributeValue(SOURCE);
		String value = element.attributeValue(VALUE);
		String file = element.attributeValue(FILE);
		ValueProcessor processor = loadOptionalValueProcessor(element, element.element(NAMESPACES) != null ? 1 : 0, allIds);
		return buildXmlParameter(loadId(element, allIds), loadPrototype(element), loadContext(element), source, value, file, processor, xpathProcessor, log);
	}
}
