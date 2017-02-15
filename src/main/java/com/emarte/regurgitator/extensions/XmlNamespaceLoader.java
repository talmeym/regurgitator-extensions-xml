package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.*;

import static com.emarte.regurgitator.core.Log.getLog;
import static com.emarte.regurgitator.core.XmlConfigUtil.getAttribute;
import static com.emarte.regurgitator.core.XmlConfigUtil.getChildElements;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.*;

public class XmlNamespaceLoader extends NamespaceLoader {
	private static final Log log = getLog(XmlNamespaceLoader.class);

	public static Map<String, String> loadNamespaces(Element element, String attribute) throws RegurgitatorException {
		if(element != null && attribute != null) {
			throw new RegurgitatorException("namespaces cannot be specified twice");
		}

		if(element == null && attribute == null) {
			throw new RegurgitatorException("namespaces not specified");
		}

		return element != null ? loadNamespaces(element) : loadNamespaces(attribute, log);
	}

	public static Map<String, String> loadNamespaces(Element element) {
		Map<String, String> namespaceMap = new HashMap<String,  String>();

		List<Element> namespaces = getChildElements(element, NAMESPACE);

		for (Element namespace: namespaces) {
			String prefix = getAttribute(namespace, NAMESPACE_PREFIX);
			String uri = getAttribute(namespace, NAMESPACE_URI);
			namespaceMap.put(prefix, uri);
			log.debug("Loaded namespace '" + prefix + "=" + uri + "'");
		}

		log.debug("Loaded " + namespaceMap.size() + " namespaces");
		return namespaceMap;
	}
}
