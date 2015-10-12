package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.*;

import static com.emarte.regurgitator.core.XmlConfigUtil.loadValueFromElementOrAttribute;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;
import static com.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class XPathProcessorXmlLoader implements XmlLoader<ValueProcessor> {
	private static Log log = Log.getLog(XPathProcessorXmlLoader.class);
	@Override
	public XPathProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		Element namespaceElement = element.element(NAMESPACES);
		String namespaceAttribute = element.attributeValue(NAMESPACES);
		Map<String,String> namespaces = loadNamespaces(namespaceElement, namespaceAttribute);
		log.debug("Loaded xpath processor");
		return new XPathProcessor(loadValueFromElementOrAttribute(element, XPATH), namespaces);
	}
}
