package com.emarte.regurgitator.extensions.config;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.XmlNamespaceLoader;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class XmlNameSpaceLoaderTest {
	@Test
	public void testThis() throws RegurgitatorException {
		assertEquals("{rge=http://extensions.regurgitator.emarte.com, rg=http://core.regurgitator.emarte.com}", XmlNamespaceLoader.loadNamespaces(null, "rg=http://core.regurgitator.emarte.com,rge=http://extensions.regurgitator.emarte.com").toString());
	}
}
