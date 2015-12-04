package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.XmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;

public class XmlParameterXmlLoader implements XmlLoader<Step> {
    private static final Log log = Log.getLog(XmlParameter.class);
	private static final XPathProcessorXmlLoader XPATH_LOADER = new XPathProcessorXmlLoader();

    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
		XPathProcessor xPathProcessor = XPATH_LOADER.load(element, allIds);
		ValueProcessor processor = loadOptionalValueProcessor(element, element.element(NAMESPACES) != null ? 1 : 0, allIds);

		String id = loadId(element, allIds);
		log.debug("Loaded xml parameter '" + id + '\'');
		return new XmlParameter(id, loadPrototype(element), loadContext(element), loadContextLocation(element), xPathProcessor, processor);
	}
}
