package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.*;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.getAttribute;
import static com.emarte.regurgitator.core.XmlConfigUtil.getChildElement;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;
import static com.emarte.regurgitator.extensions.XmlNamespaceLoader.loadNamespaces;

public class XpathProcessorXmlLoader implements XmlLoader<XpathProcessor> {
	private static final Log log = getLog(XpathProcessorXmlLoader.class);

	@Override
	public XpathProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		Map<String,String> namespaces = loadNamespaces(getChildElement(element, NAMESPACES), getAttribute(element, NAMESPACES));

		log.debug("Loaded xpath processor");
		return new XpathProcessor(getAttribute(element, XPATH), namespaces);
	}
}
