package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;

public class FreemarkerBuilderXmlLoader extends FreemarkerBuilderLoader implements XmlLoader<ValueBuilder> {
	private static final Log log = Log.getLog(FreemarkerBuilderXmlLoader.class);

    @Override
    public ValueBuilder load(Element element, Set<Object> allIds) throws RegurgitatorException {
		String source = element.attributeValue(SOURCE);
		String text = element.getText();
		String value = text != null && text.length() > 0 ? text : null;
		String file = element.attributeValue(FILE);
		return buildFreemarkerValueBuilder(source, value, file, log);
    }
}
