package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.FILE;
import static com.emarte.regurgitator.core.Log.getLog;

public class FreemarkerProcessorXmlLoader extends FreemarkerProcessorLoader implements XmlLoader<ValueProcessor> {
	private static final Log log = getLog(FreemarkerProcessorXmlLoader.class);

    @Override
    public ValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		String text = element.getText();
		String value = text != null && text.length() > 0 ? text : null;
		String file = element.attributeValue(FILE);
		return buildFreemarkerValueProcessor(value, file, log);
    }
}
