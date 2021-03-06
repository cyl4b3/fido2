/**
* Copyright StrongAuth, Inc. All Rights Reserved.
*
* Use of this source code is governed by the GNU Lesser General Public License v2.1
* The license can be found at https://github.com/StrongKey/fido2/blob/master/LICENSE
*
 * *********************************************
 *                    888
 *                    888
 *                    888
 *  88888b.   .d88b.  888888  .d88b.  .d8888b
 *  888 "88b d88""88b 888    d8P  Y8b 88K
 *  888  888 888  888 888    88888888 "Y8888b.
 *  888  888 Y88..88P Y88b.  Y8b.          X88
 *  888  888  "Y88P"   "Y888  "Y8888   88888P'
 *
 * *********************************************
 *
 * Remote interface for u2fDeregisterBean
 *
 */
package com.strongkey.skfs.txbeans.v1;

import com.strongkey.skfs.utilities.SKCEReturnObject;
import javax.ejb.Remote;

@Remote
public interface u2fDeregisterBeanRemote_v1 {

    /**
     * This method is responsible for deleting the user registered key from the
     * persistent storage. This method first checks if the given ramdom id is
     * mapped in memory to the specified user and if found yes, gets the registration
     * key id and deletes that entry from the database.
     *
     * Additionally, if the key being deleted is the last one for the user, the
     * ldap attribute of the user called 'FIDOKeysEnabled' is set to 'no'.
     *
     * @param did       - FIDO domain id
     * @param protocol  - U2F protocol version to comply with.
     * @param username  - username
     * @param randomid  - random id that is unique to one fido registered authenticator
     *                      for the user.
     * @return          - returns SKCEReturnObject in both error and success cases.
     *                  In error case, an error key and error msg would be populated
     *                  In success case, a simple msg saying that the process was
     *                  successful would be populated.
     */
    public SKCEReturnObject remoteExecute(String did,
                                    String protocol,
                                    String username,
                                    String randomid);
}
