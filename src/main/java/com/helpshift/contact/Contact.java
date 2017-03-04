package com.helpshift.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * Created by naveen.nahata on 04/03/17.
 */
@Data
@AllArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return (firstName == contact.firstName ||
                (firstName != null && firstName.equalsIgnoreCase(contact.getFirstName())))
                &&
                (lastName == contact.lastName ||
                        (lastName != null && lastName.equalsIgnoreCase(contact.getLastName())));
    }

    public static String displayContact(Contact contact) {
        return StringUtils.isEmpty(contact.getFirstName()) ? contact.getLastName() : (StringUtils.isEmpty(contact
                .getLastName()) ? contact.getFirstName() : contact.getFirstName() + " " + contact.getLastName());
    }

}
