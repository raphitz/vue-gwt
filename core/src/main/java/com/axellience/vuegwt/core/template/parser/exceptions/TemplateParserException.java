package com.axellience.vuegwt.core.template.parser.exceptions;

import com.axellience.vuegwt.core.template.parser.context.TemplateParserContext;

/**
 * A generic exception thrown when parsing the template
 * @author Adrien Baron
 */
public class TemplateParserException extends RuntimeException
{
    public TemplateParserException(String message, TemplateParserContext context)
    {
        this(message, context, null);
    }

    public TemplateParserException(String message, TemplateParserContext context, Throwable cause)
    {
        super("\n\n======================= Error in: \""
            + context.getTemplateName()
            + "\" =======================\n\n"
            + message
            + "\n\nWhile processing Node: "
            + context.getCurrentNode().toString()
            + "\n\n==============================================\n", cause);
    }
}
