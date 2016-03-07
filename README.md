# regurgitator-extensions-xml

regurgitator is a modular, light-weight, extendable java-based processing framework designed to 'regurgitate' canned or clever responses to incoming requests; useful for mocking or prototyping services.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

read more about regurgitator in xml here: [regurgitator-core-xml](http://github.com/talmeym/regurgitator-core-xml#xml-configuration-of-regurgitator)

## extension steps in xml

### json-parameter

a json-parameter creates a parameter, extracting it's value from within a json document, using json-path:

```xml
<rge:json-parameter name="book-name" source="book-catalogue" json-path="$.catalogue.book.name"/>
```

### xml-parameter

an xml-parameter creates a parameter, extracting it's value from within an xml document, using xpath:

```xml
<rge:xml-parameter name="book-name" source="book-catalogue" xpath="/bk:catalogue/bk:book/bk:name">
	<rge:namespaces>
		<rge:namespace prefix="bk" uri="http://books.com"/>
	</rge:namespaces>
</rge:xml-parameter>
```

## extension constructs in xml

### freemarker-builder 

a freemarker-builder agregating parameter values together using a freemarker template.

```xml
<rge:freemarker-builder source="template-param"/>

<rge:freemarker-builder file="classpath:/template.ftl"/>

<rge:freemarker-builder value="This is a ${descriptive} day!"/>
```

a freemarker-builder can use the same value source attributes as other steps, such as ``create-parameter``, getting it's template text from a source parameter, a file or an explicit value, specified as an attribute or element text (but not both).

a freemarker-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` attribute is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, eg. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```xml
<rge:freemarker-builder all-contexts="true">
	{
		"response": "${response_payload.text}",
		"status-code": "${response-metadata.status_code}",
		"content-type": "${response-metadata.content_type}"
	}
</rge:freemarker-builder>
```

### velocity-builder

### json-path-processor

### xpath-processor

### freemarker-processor

### velocity-processor

### xml-schema-validator
