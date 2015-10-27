package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;

public class VelocityProcessorXmlLoader extends VelocityProcessorLoader implements XmlLoader<ValueProcessor> {
	private static final Log log = Log.getLog(VelocityProcessorXmlLoader.class);

    @Override
    public ValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		String text = element.getText();
		String value = text != null && text.length() > 0 ? text : null;
		String file = element.attributeValue(FILE);
		return buildVelocityValueProcessor(value, file, log);
    }
}
