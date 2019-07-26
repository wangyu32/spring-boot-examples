@XmlSchema(
        namespace = "http://www.w3.org/2000/09/xmldsig#",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(namespaceURI = "http://www.w3.org/2000/09/xmldsig#", prefix = "")
        }
)
package com.baiwang.cloud.common.model.sign;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;