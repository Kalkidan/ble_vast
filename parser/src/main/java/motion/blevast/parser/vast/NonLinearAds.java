package motion.blevast.parser.vast;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.parser.parser.Tag;

/**
 * Non linear Tag.
 *
 *<NonLinearAds>
 *<TrackingEvents>{0,1}</TrackingEvents>
 *<NonLinear apiFramework="" expandedHeight="" expandedWidth="" height=""
 * id="" maintainAspectRatio="" minSuggestedDuration="" scalable="" width="">{1,unbounded}</NonLinear>
 *</NonLinearAds>
 *Source-
 *<xs:element name="NonLinearAds" minOccurs="0" maxOccurs="1">
 *<xs:complexType>
 *<xs:sequence>
 *<xs:element name="TrackingEvents" minOccurs="0" type="TrackingEvents_type" maxOccurs="1">
 *</xs:element>
 *<xs:element name="NonLinear" minOccurs="1" maxOccurs="unbounded" type="NonLinear_type">
 *<xs:annotation>
 *<xs:documentation>Any number of companions in any desired pixel dimensions.</xs:documentation>
 *</xs:annotation>
 *</xs:element>
 *</xs:sequence>
 *</xs:complexType>
 *</xs:element>
 */

public class NonLinearAds {

    @Tag("NonLinear") private List<NonLinear> nonLinears = new ArrayList<>();

    @Tag("TrackingEvents")private TrackingEvents trackingEvents;

    public List<NonLinear> getNonLinearList() {
        return nonLinears;
    }

    public TrackingEvents getTrackingEvents() {
        return trackingEvents;
    }
}
