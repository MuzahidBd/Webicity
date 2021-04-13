package everyos.browser.jhtml.parser;

public enum TokenizeState {
	DATA, CHARACTER_REFERENCE, TAG_OPEN, RCDATA, RCDATA_LT_SIGN, RAWTEXT, RAWTEXT_LT_SIGN, SCRIPT_DATA, SCRIPT_DATA_LT_SIGN, PLAINTEXT, MARKUP_DECLARATION_OPEN, 
	END_TAG_OPEN, TAG_NAME, BOGUS_COMMENT, BEFORE_ATTRIBUTE_NAME, SELF_CLOSING_START_TAG, RCDATA_END_TAG_OPEN, RCDATA_END_TAG_NAME, RAWTEXT_END_TAG_OPEN, RAWTEXT_END_TAG_NAME,
	SCRIPT_DATA_END_TAG_OPEN, SCRIPT_DATA_ESCAPE_START, SCRIPT_DATA_END_TAG_NAME, SCRIPT_DATA_ESCAPE_START_DASH, SCRIPT_DATA_ESCAPED,
	SCRIPT_DATA_ESCAPED_DASH, SCRIPT_DATA_ESCAPED_LT_SIGN, SCRIPT_DATA_ESCAPED_DASH_DASH, SCRIPT_DATA_ESCAPED_END_TAG_OPEN, SCRIPT_DATA_DOUBLE_ESCAPE_START,
	SCRIPT_DATA_ESCAPED_END_TAG_NAME, SCRIPT_DATA_DOUBLE_ESCAPED, SCRIPT_DATA_DOUBLE_ESCAPED_DASH, SCRIPT_DATA_DOUBLE_ESCAPED_LT_SIGN, SCRIPT_DATA_DOUBLE_ESCAPED_DASH_DASH,
	SCRIPT_DATA_DOUBLE_ESCAPE_END, AFTER_ATTRIBUTE_NAME, ATTRIBUTE_NAME, BEFORE_ATTRIBUTE_VALUE, ATTRIBUTE_VALUE_DQ, ATTRIBUTE_VALUE_SQ, ATTRIBUTE_VALUE_UQ,
	AFTER_ATTRIBUTE_VALUE_QUOTED, COMMENT_START, DOCTYPE, COMMENT_START_DASH, COMMENT, COMMENT_END, COMMENT_LT_SIGN, COMMENT_END_DASH, COMMENT_LT_SIGN_BANG,
	COMMENT_LT_SIGN_BANG_DASH, COMMENT_LT_SIGN_BANG_DASH_DASH, COMMENT_END_BANG, BEFORE_DOCTYPE_NAME, DOCTYPE_NAME, AFTER_DOCTYPE_NAME, NAMED_CHARACTER_REFERENCE
}