# regurgitator-extensions-xml

regurgitator is a modular, light-weight, extendable java-based processing framework designed to 'regurgitate' canned or clever responses to incoming requests; useful for mocking or prototyping services.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

read more about regurgitator in xml here: [regurgitator-core-xml](http://github.com/talmeym/regurgitator-core-xml#xml-configuration-of-regurgitator)

## extension steps in xml

### json-parameter

a json-parameter creates a parameter, extracting its value from within a json document, using json-path:

```xml
<rge:json-parameter name="book-name" source="book-catalogue" json-path="$.catalogue.book.name"/>
```

### xml-parameter

an xml-parameter creates a parameter, extracting its value from within an xml document, using xpath:

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

a freemarker-builder can use the same value source attributes as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value, specified as an attribute or element text (but not both).

a freemarker-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` attribute is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, eg. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```xml
<rge:freemarker-builder all-contexts="true">
	{
		"response": "${response_payload.text}",
		"status-code": ${response-metadata.status_code},
		"content-type": "${response-metadata.content_type}"
	}
</rge:freemarker-builder>
```

### velocity-builder

```xml
<rge:velocity-builder source="template-param"/>

<rge:velocity-builder file="classpath:/template.ftl"/>

<rge:velocity-builder value="This is a ${descriptive} day!"/>
```

a velocity-builder can use the same value source attributes as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value, specified as an attribute or element text (but not both).

a velocity-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` attribute is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, eg. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```xml
<rge:velocity-builder all-contexts="true">
	{
		"response": "${response_payload.text}",
		"status-code": ${response-metadata.status_code},
		"content-type": "${response-metadata.content_type}"
	}
</rge:velocity-builder>
```

### json-path-processor

a json-path-processor processes a parameter value, extracting a value from it using json path.

```xml
<rg:create-parameter name="book-name" source="book-catalogue">
	<rge:json-path-processor>$.catalogue.book.name</rge:json-path-processor>
</rg:create-parameter>
```

### xpath-processor

an xpath-processor processes a parameter value, extracting a value from it using xpath.

```xml
<rg:create-parameter name="book-name" source="book-catalogue">
	<rge:xpath-processor namespaces="cat=http://catalogues.com,bk=http://books.com" xpath="/cat:catalogue/bk:book/@name"/>
</rg:create-parameter>
```

namespaces for an xpath-processor can also be declared as a child element of the processor:

```xml
<rg:create-parameter name="book-name" source="book-catalogue">
	<rge:xpath-processor xpath="/cat:catalogue/bk:book/@name">
		<rge:namespaces>
			<rge:namespace prefix="cat" uri="http://catalogues.com"/>
			<rge:namespace prefix="bk" uri="http://books.com"/>
		</rge:namespaces>
	</rge:xpath-processor>
</rg:create-parameter>
```

### freemarker-processor

a freemarker-processor processes a parameter value, formatting the value using a freemarker template.

```xml
<rg:create-response source="unformatted-response">
	<rge:freemarker-processor file="classpath:/template.ftl"/>
</rg:create-response>

<rg:create-response source="unformatted-response">
	<rge:freemarker-processor>The response was: ${value}</rge:freemarker-processor>
</rg:create-response>
```

the parameter value is made available to the template as simply ``value``. the template text can be specified in the element text or drawn in from a file.

### velocity-processor

a velocity-processor processes a parameter value, formatting the value using a velocity template.

```xml
<rg:create-response source="unformatted-response">
	<rge:velocity-processor file="classpath:/template.ftl"/>
</rg:create-response>

<rg:create-response source="unformatted-response">
	<rge:velocity-processor>The response was: ${value}</rge:velocity-processor>
</rg:create-response>
```

the parameter value is made available to the template as simply ``value``. the template text can be specified in the element text or drawn in from a file.

### xml-schema-validator

an xml-schema-validator is a ``value-processor`` that validates a parameter value against an xml-schema file.

```xml
<rg:create-response source="response">
	<rge:xml-schema-validator file="classpath:/response_schema.xsd"/>
</rg:create-response>
```

validating a parameter value can be useful in ensuring that your configured logic and processing always returns valid responses. if the value fails validation, an exception is thrown; if it passes, the value is passed through unchanged.
