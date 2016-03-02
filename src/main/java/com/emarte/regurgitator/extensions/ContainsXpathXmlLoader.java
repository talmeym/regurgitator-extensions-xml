package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.*;

import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.NAMESPACES;
import static com.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class ContainsXpathXmlLoader implements XmlLoader<ContainsXpath> {
	private static final Log log = Log.getLog(ContainsXpathXmlLoader.class);

	@Override
	public ContainsXpath load(Element element, Set<Object> allIds) throws RegurgitatorException {
		Map<String,String> namspaces = loadNamespaces(element.attributeValue(NAMESPACES), log);
		log.debug("Loaded ContainsXath");
		return new ContainsXpath(namspaces);
	}
}
