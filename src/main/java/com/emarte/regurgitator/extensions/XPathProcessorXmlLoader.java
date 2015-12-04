package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.*;

import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;
import static com.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class XPathProcessorXmlLoader implements XmlLoader<ValueProcessor> {
	private static final Log log = Log.getLog(XPathProcessorXmlLoader.class);

	@Override
	public XPathProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		Map<String,String> namespaces = loadNamespaces(element.element(NAMESPACES), element.attributeValue(NAMESPACES));

		log.debug("Loaded xpath processor");
		return new XPathProcessor(element.attributeValue(XPATH), namespaces);
	}
}
