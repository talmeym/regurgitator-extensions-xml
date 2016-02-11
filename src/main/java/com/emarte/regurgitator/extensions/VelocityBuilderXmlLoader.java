package com.emarte.regurgitator.extensions;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.CoreConfigConstants.*;
import static com.emarte.regurgitator.core.XmlConfigUtil.loadOptionalBoolean;
import static com.emarte.regurgitator.extensions.ExtensionsConfigConstants.ALL_CONTEXTS;

public class VelocityBuilderXmlLoader extends VelocityBuilderLoader implements XmlLoader<ValueBuilder> {
	private static final Log log = Log.getLog(VelocityBuilderXmlLoader.class);

	@Override
	public ValueBuilder load(Element element, Set<Object> allIds) throws RegurgitatorException {
		String source = element.attributeValue(SOURCE);
		String valueAttr = element.attributeValue(VALUE);
		String valueText = element.getText();
		String value = valid(valueAttr) ? valueAttr : valid(valueText) ? valueText : null;
		String file = element.attributeValue(FILE);
		return buildVelocityValueBuilder(source, value, file, loadOptionalBoolean(element, ALL_CONTEXTS), log);
	}

	private boolean valid(String text) {
		return text != null && text.length() > 0;
	}
}
