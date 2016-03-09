package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.Log.getLog;

public class XmlSchemaValidatorXmlLoader implements XmlLoader<XmlSchemaValidator> {
	private static final Log log = getLog(XmlSchemaValidatorXmlLoader.class);

    @Override
    public XmlSchemaValidator load(Element element, Set<Object> allIds) throws RegurgitatorException {
		log.debug("Loaded xml schema validator");
		return new XmlSchemaValidator(element.attributeValue(FILE));
    }
}
