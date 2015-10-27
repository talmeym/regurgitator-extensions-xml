package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;

public class XmlSchemaValidatorXmlLoader implements XmlLoader<ValueProcessor> {
	private static final Log log = Log.getLog(XmlSchemaValidatorXmlLoader.class);

    @Override
    public ValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		String schemaPath = element.attributeValue(FILE);

		log.debug("Loaded xml schema validator");
		return new XmlSchemaValidator(schemaPath);
    }
}
