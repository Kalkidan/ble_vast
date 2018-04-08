package motion.blevast.parser.parser;

/**
 * When parsing through an xsd, its outcomes are reported
 * as per the grammar in the XSD. This contract exposes the
 * report to the UI lever.
 */

public interface XSDParsingReport {
    void onXSDValidationReport(String report);
}
