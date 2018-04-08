package motion.blevast.parser.parser;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A retention policy determines at what point annotation should be discarded.
 * Java defined 3 types of retention policies through java.lang.annotation.RetentionPolicy enumeration. It has SOURCE, CLASS and RUNTIME.
 * Annotation with retention policy SOURCE will be retained only with source code, and discarded during compile time.
 * Annotation with retention policy CLASS will be retained till compiling the code, and discarded during runtime.
 * Annotation with retention policy RUNTIME will be available to the JVM through runtime.
 * The retention policy will be specified by using java built-in annotation @Retention, and we have to pass the retention policy type.
 * <p>
 * The default retention policy type is CLASS.
 *
 * idea borrowed from
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Attribute {

    String value() default "";

}
