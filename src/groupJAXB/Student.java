
package groupJAXB;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subject",
    "average"
})
@XmlRootElement(name = "student")
public class Student {

    @XmlAttribute(name = "firstname", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String firstname;
    @XmlAttribute(name = "lastname", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lastname;
    @XmlAttribute(name = "groupnumber", required = true)
    protected int groupnumber;
    protected List<Subject> subject;
    protected float average;

    public float countAverage(){
        float sum = 0;
        for (Subject subject : getSubject()){
            sum += subject.getMark();
        }
        return sum/getSubject().size();
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the groupnumber property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public int getGroupnumber() {
        return groupnumber;
    }

    /**
     * Sets the value of the groupnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setGroupnumber(int value) {
        this.groupnumber = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Subject }
     * 
     * 
     */
    public List<Subject> getSubject() {
        if (subject == null) {
            subject = new ArrayList<Subject>();
        }
        return this.subject;
    }

    /**
     * Gets the value of the countAverage property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public float getAverage() {
        return average;
    }

    /**
     * Sets the value of the countAverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setAverage(float value) {
        this.average = value;
    }

}
